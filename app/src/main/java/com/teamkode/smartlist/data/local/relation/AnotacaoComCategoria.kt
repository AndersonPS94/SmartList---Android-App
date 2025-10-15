package com.teamkode.smartlist.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.teamkode.smartlist.data.local.entity.AnotacaoEntity
import com.teamkode.smartlist.data.local.entity.CategoriasEntity

data class AnotacaoComCategoria(
    @Embedded val anotacao: AnotacaoEntity,
    @Relation(parentColumn = "categoriaId", entityColumn = "id")
    val categoria : CategoriasEntity
)
