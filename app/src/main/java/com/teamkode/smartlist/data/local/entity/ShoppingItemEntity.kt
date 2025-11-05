package com.teamkode.smartlist.data.local.entity

import android.provider.SyncStateContract
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.teamkode.smartlist.domain.DomainConstantes

@Entity(tableName = DomainConstantes.TABLE_SHOPPINGITEM)
data class ShoppingItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val category: String,
    val isPurchased: Boolean = false,
    val dateAdded: Long = System.currentTimeMillis()
)
