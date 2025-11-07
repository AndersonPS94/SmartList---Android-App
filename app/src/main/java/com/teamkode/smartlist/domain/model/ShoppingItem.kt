package com.teamkode.smartlist.domain.model

data class ShoppingItem(
    val id: Long = 0,
    val name: String,
    val category: String,
    val isPurchased: Boolean = false,
    val dateAdded: Long = System.currentTimeMillis()
)
