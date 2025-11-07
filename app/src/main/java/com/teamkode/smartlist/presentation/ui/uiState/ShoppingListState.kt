package com.teamkode.smartlist.ui.uiState

import com.teamkode.smartlist.domain.model.ShoppingItem
import com.teamkode.smartlist.ui.FilterType

data class ShoppingListState(
    val items: List<ShoppingItem> = emptyList(),
    val currentFilter: FilterType = FilterType.ALL,
    val isLoading: Boolean = false
)