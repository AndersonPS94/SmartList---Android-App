package com.teamkode.smartlist.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.teamkode.smartlist.data.converters.LocalDateTimeConverter
import com.teamkode.smartlist.data.local.dao.ShoppingItemDao
import com.teamkode.smartlist.data.local.entity.ShoppingItemEntity
import com.teamkode.smartlist.domain.DomainConstantes

@Database(entities = [ShoppingItemEntity::class], version = 1, exportSchema = false)
@TypeConverters(LocalDateTimeConverter::class)
abstract class ShoppingItemDatabase() : RoomDatabase() {

abstract fun ShoppingItemDao(): ShoppingItemDao

    companion object {
        @Volatile
        private var INSTANCE: ShoppingItemDatabase? = null

        fun getDatabase(context: Context): ShoppingItemDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, ShoppingItemDatabase::class.java,
                    DomainConstantes.DATABASE_SMARTLIST
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}