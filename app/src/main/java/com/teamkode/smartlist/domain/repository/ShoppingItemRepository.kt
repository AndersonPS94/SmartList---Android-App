package com.teamkode.smartlist.domain.repository

import com.teamkode.smartlist.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow

interface ShoppingItemRepository {
    fun getAllShoppingItems(): Flow<List<ShoppingItem>>
    suspend fun getShoppingItemById(id: Int): ShoppingItem?
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)
    suspend fun updateShoppingItem(shoppingItem: ShoppingItem)
    suspend fun togglePurchasedStatus(itemId: Int, isPurchased: Boolean)
}


