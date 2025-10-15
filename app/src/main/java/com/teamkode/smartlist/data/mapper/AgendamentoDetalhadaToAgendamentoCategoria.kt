package com.teamkode.smartlist.data.mapper

import com.teamkode.smartlist.data.local.relation.AnotacaoComCategoria
import com.teamkode.smartlist.domain.AnotacaoDetalhada
import com.teamkode.smartlist.domain.Categorias
import java.time.LocalDateTime
import kotlin.Long

fun AnotacaoComCategoria.toAnotacaoDetalhada(): AnotacaoDetalhada {
    return AnotacaoDetalhada(
        id =this.anotacao.id,
        titulo =this.anotacao.titulo,
        anotacao =this.anotacao.anotacao,
        data =this.anotacao.data,
        categoria = this.categoria.id
    )
}