package com.teamkode.smartlist.presentation.uIState

import com.teamkode.smartlist.domain.model.Category

data class CategoryState(
    val categories: List<Category> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)