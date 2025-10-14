package com.teamkode.smartlist.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.teamkode.smartlist.domain.Categorias
import com.teamkode.smartlist.domain.DomainConstantes
import java.time.LocalDateTime

@Entity(DomainConstantes.TABLE_ANOTACOES)
data class AnotacaoEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0,
    val titulo:String,
    val categoria:Categorias,
    val anotacao:String,
    val data: LocalDateTime
)
