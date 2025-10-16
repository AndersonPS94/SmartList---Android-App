package com.teamkode.smartlist.data.mapper

import com.teamkode.smartlist.data.local.entity.AnotacaoEntity
import com.teamkode.smartlist.domain.Anotacao
import java.time.LocalDateTime
import kotlin.Long

fun Anotacao.toEntity(): AnotacaoEntity {
    return AnotacaoEntity(
        id = this.id,
        titulo = this.titulo,
        categoriaId = this.categoriaId,
        anotacao = this.anotacao,
        data = this.data
    )
}