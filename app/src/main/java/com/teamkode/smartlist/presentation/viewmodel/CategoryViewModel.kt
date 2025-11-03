package com.teamkode.smartlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamkode.smartlist.domain.model.Category
import com.teamkode.smartlist.domain.usecase.ShoppingUseCases
import com.teamkode.smartlist.presentation.uIState.CategoryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val useCases: ShoppingUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(CategoryState())
    val state: StateFlow<CategoryState> = _state

    init {
        useCases.getCategories().onEach { categories ->
            _state.value = _state.value.copy(
                categories = categories,
                isLoading = false
            )
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: CategoryEvent) {
        when (event) {
            is CategoryEvent.InsertCategory -> {
                viewModelScope.launch {
                    try {
                        useCases.insertCategory(event.category)
                    } catch (e: IllegalArgumentException) {
                        _state.value = _state.value.copy(error = e.message)
                    }
                }
            }
            is CategoryEvent.DeleteCategory -> {
                viewModelScope.launch {
                    useCases.deleteCategory(event.category)
                }
            }
        }
    }

    fun clearError() {
        _state.value = _state.value.copy(error = null)
    }
}

sealed class CategoryEvent {
    data class InsertCategory(val category: Category) : CategoryEvent()
    data class DeleteCategory(val category: Category) : CategoryEvent()
}