package com.teamkode.smartlist.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.teamkode.smartlist.domain.DomainConstantes

@Entity(DomainConstantes.TABLE_CATEGORIAS)
data class CategoriasEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val categoria: String
)
