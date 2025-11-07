package com.teamkode.smartlist.data.local.dao

import androidx.room.*
import com.teamkode.smartlist.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingItemDao {
    @Query("SELECT * FROM shopping_items ORDER BY dateAdded DESC")
    fun getAllShoppingItems(): Flow<List<ShoppingItem>>

    @Query("SELECT * FROM shopping_items WHERE id = :id")
    suspend fun getShoppingItemById(id: Int): ShoppingItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(item: ShoppingItem)

    @Delete
    suspend fun deleteShoppingItem(item: ShoppingItem)

    @Query("UPDATE shopping_items SET isPurchased = :isPurchased WHERE id = :itemId")
    suspend fun updatePurchasedStatus(itemId: Int, isPurchased: Boolean)
}
