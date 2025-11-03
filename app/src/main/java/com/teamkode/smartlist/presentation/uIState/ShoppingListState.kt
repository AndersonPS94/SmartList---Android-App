package com.teamkode.smartlist.presentation.uIState

import com.teamkode.smartlist.domain.model.Category
import com.teamkode.smartlist.domain.model.ShoppingItem

data class ShoppingListState(
    val items: List<ShoppingItem> = emptyList(),
    val categories: List<Category> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)
