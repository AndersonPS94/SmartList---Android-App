package com.teamkode.smartlist.data.mapper

import com.teamkode.smartlist.data.local.entity.CategoriasEntity
import com.teamkode.smartlist.domain.Categorias

fun Categorias.toEntity(): CategoriasEntity{
    return CategoriasEntity(
        id = this.id,
        categoria = this.categoria
    )
}