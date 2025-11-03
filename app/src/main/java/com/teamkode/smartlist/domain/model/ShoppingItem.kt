package com.teamkode.smartlist.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val categoryId: Int,
    val isPurchased: Boolean = false,
    val dateAdded: Long = System.currentTimeMillis()
)
