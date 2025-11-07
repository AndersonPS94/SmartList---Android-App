package com.teamkode.smartlist.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.teamkode.smartlist.data.local.dao.CategoryDao
import com.teamkode.smartlist.data.local.dao.ShoppingItemDao
import com.teamkode.smartlist.domain.model.Category
import com.teamkode.smartlist.domain.model.ShoppingItem

@Database(
    entities = [ShoppingItem::class, Category::class],
    version = 1,
    exportSchema = false
)
abstract class ShoppingListDatabase : RoomDatabase() {

    abstract fun shoppingItemDao(): ShoppingItemDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        const val DATABASE_NAME = "shopsmart_db"
    }
}
