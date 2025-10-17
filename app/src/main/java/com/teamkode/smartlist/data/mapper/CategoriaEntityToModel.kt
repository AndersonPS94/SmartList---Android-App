package com.teamkode.smartlist.data.mapper

import com.teamkode.smartlist.data.local.entity.CategoriasEntity
import com.teamkode.smartlist.domain.Categorias

fun CategoriasEntity.toModel(): Categorias{
    return Categorias(
        id = this.id,
        categoria = this.categoria
    )
}