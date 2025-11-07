package com.teamkode.smartlist.domain.repository

import com.teamkode.smartlist.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow

interface ShoppingItemRepository {

    fun getAllItems(): Flow<List<ShoppingItem>>

    suspend fun getItemById(id:Long) : ShoppingItem?

    suspend fun insertItem(item: ShoppingItem)

    suspend fun updateItem(item: ShoppingItem)

    suspend fun deleteItem(item: ShoppingItem)

    suspend fun deleteAllItems()
}


