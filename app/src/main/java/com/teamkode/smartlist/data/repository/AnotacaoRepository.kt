package com.teamkode.smartlist.data.repository

import com.teamkode.smartlist.data.local.entity.AnotacaoEntity
import com.teamkode.smartlist.data.local.relation.AnotacaoComCategoria
import com.teamkode.smartlist.domain.Anotacao
import com.teamkode.smartlist.domain.AnotacaoDetalhada
import kotlinx.coroutines.flow.Flow

interface AnotacaoRepository {

    suspend fun insertAnotacao(item: Anotacao)

    suspend fun deleteAnotacao(item: Anotacao)

    fun getAllAnotacoes(): Flow<List<AnotacaoDetalhada>>

    suspend fun getAnotacaoByText(texto: String): List<AnotacaoDetalhada>

    suspend fun getAnotacaoById(itemId: Int): AnotacaoDetalhada

    fun getAnotacaoComCategoria(): Flow<List<AnotacaoDetalhada>>

}