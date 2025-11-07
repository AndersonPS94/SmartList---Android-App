package com.teamkode.smartlist.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamkode.smartlist.domain.model.ShoppingItem
import com.teamkode.smartlist.domain.usecase.DeleteShoppingItemUseCase
import com.teamkode.smartlist.domain.usecase.GetAllShoppingItemsUseCase
import com.teamkode.smartlist.domain.usecase.InsertShoppingItemUseCase
import com.teamkode.smartlist.domain.usecase.ToggleItemPurchaseStatusUseCase
import com.teamkode.smartlist.ui.FilterType
import com.teamkode.smartlist.ui.uiState.ShoppingListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewmodel @Inject constructor(
    private val getAllItemsUseCase: GetAllShoppingItemsUseCase,
    private val inserItemUseCase: InsertShoppingItemUseCase,
    private val toggleStatusUseCase: ToggleItemPurchaseStatusUseCase,
    private val deleteItemUseCase: DeleteShoppingItemUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ShoppingListState())
    val state: StateFlow<ShoppingListState> = _state.asStateFlow()

    private val allItemsFlow = getAllItemsUseCase()

    init {
        viewModelScope.launch {
            combine(
                allItemsFlow,
            _state.map { it.currentFilter }
            ){items, filter ->
                val filteredList = when(filter){
                    FilterType.PURCHASED -> items.filter { it.isPurchased }
                    FilterType.UNPURCHASED -> items.filter { !it.isPurchased }
                    FilterType.ALL -> items
                }

                _state.value.copy(items = filteredList, isLoading = false)
            }.collect { newSate ->
                _state.value = newSate
             }
        }
    }

    fun onFilterChange(newFilter: FilterType){
     _state.value = _state.value.copy(currentFilter = newFilter)
    }

    fun onTogglePuchaseStatus(item: ShoppingItem){
        viewModelScope.launch {
            toggleStatusUseCase(item)
        }
    }

    fun onAddNewItem(name: String, category: String){
        if(name.isBlank()) return
        viewModelScope.launch {
            val newItem = ShoppingItem(
                name = name.trim(),
                category = category.trim().ifBlank { "Geral" }
            )
            inserItemUseCase(newItem)
        }
    }

    fun onDeleteItem(item: ShoppingItem){
        viewModelScope.launch {
            deleteItemUseCase(item)
        }
    }
}