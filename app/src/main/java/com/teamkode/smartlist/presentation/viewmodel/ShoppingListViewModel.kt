package com.teamkode.smartlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamkode.smartlist.domain.model.ShoppingItem
import com.teamkode.smartlist.domain.usecase.ShoppingUseCases
import com.teamkode.smartlist.presentation.uIState.ShoppingListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val useCases: ShoppingUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(ShoppingListState())
    val state: StateFlow<ShoppingListState> = _state

    init {
        getShoppingData()
    }

    private fun getShoppingData() {

        combine(
            useCases.getShoppingItems(),
            useCases.getCategories()
        ) { items, categories ->
            ShoppingListState(
                items = items,
                categories = categories,
                isLoading = false
            )
        }.onEach { newState ->
            _state.value = newState
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: ShoppingListEvent) {
        when (event) {
            is ShoppingListEvent.TogglePurchased -> {
                viewModelScope.launch {
                    useCases.togglePurchasedStatus(event.item.id, !event.item.isPurchased)
                }
            }
            is ShoppingListEvent.DeleteItem -> {
                viewModelScope.launch {
                    useCases.deleteShoppingItem(event.item)
                }
            }
            is ShoppingListEvent.InsertItem -> {
                viewModelScope.launch {
                    try {
                        useCases.insertShoppingItem(event.item)
                    } catch (e: IllegalArgumentException) {
                        _state.value = _state.value.copy(error = e.message)
                    }
                }
            }
        }
    }
}

sealed class ShoppingListEvent {
    data class TogglePurchased(val item: ShoppingItem) : ShoppingListEvent()
    data class DeleteItem(val item: ShoppingItem) : ShoppingListEvent()
    data class InsertItem(val item: ShoppingItem) : ShoppingListEvent()
}