package com.teamkode.smartlist.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.teamkode.smartlist.data.local.entity.AnotacaoEntity
import com.teamkode.smartlist.domain.DomainConstantes

@Database(entities = [AnotacaoEntity::class], version = 1, exportSchema = false)
abstract class SmartListDataBase() : RoomDatabase() {

//abstract fun smartItemDao(): SmartItemDao

    companion object {
        @Volatile
        private var INSTANCE: SmartListDataBase? = null

        fun getDatabase(context: Context): SmartListDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, SmartListDataBase::class.java,
                    DomainConstantes.DATABASE_SMARTLIST
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}