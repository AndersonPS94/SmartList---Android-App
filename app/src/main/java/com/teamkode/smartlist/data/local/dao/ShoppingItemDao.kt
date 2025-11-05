package com.teamkode.smartlist.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.teamkode.smartlist.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingItemDao {

    @Query("SELECT * FROM shopping_item ORDER BY dateAdded DESC")
    fun getAllItems(): Flow<List<ShoppingItem>>

    @Query("SELECT * FROM shopping_item WHERE id = :id")
    suspend fun getItemById(id:Long) : ShoppingItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ShoppingItem)

    @Update
    suspend fun updateItem(item: ShoppingItem)

    @Delete
    suspend fun deleteItem(item: ShoppingItem)

    @Query("DELETE FROM shopping_item")
    suspend fun deleteAllItems()
}