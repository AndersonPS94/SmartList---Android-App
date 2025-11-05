package com.teamkode.smartlist.data.repository

import com.teamkode.smartlist.data.local.dao.ShoppingItemDao
import com.teamkode.smartlist.domain.model.ShoppingItem
import com.teamkode.smartlist.domain.repository.ShoppingItemRepository
import kotlinx.coroutines.flow.Flow

class ShoppingItemRepositoryImpl(
    private val dao: ShoppingItemDao
) : ShoppingItemRepository {

    override fun getAllShoppingItems(): Flow<List<ShoppingItem>> {
        return dao.getAllShoppingItems()
    }

    override suspend fun getShoppingItemById(id: Int): ShoppingItem? {
        return dao.getShoppingItemById(id)
    }

    override suspend fun insertShoppingItem(item: ShoppingItem) {
        dao.insertShoppingItem(item)
    }

    override suspend fun deleteShoppingItem(item: ShoppingItem) {
        dao.deleteShoppingItem(item)
    }

    override suspend fun updateShoppingItem(item: ShoppingItem) {
        dao.insertShoppingItem(item)
    }

    override suspend fun togglePurchasedStatus(itemId: Int, isPurchased: Boolean) {
        dao.updatePurchasedStatus(itemId, isPurchased)
    }
}
