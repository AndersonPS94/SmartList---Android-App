package com.teamkode.smartlist.data.repository

import com.teamkode.smartlist.data.local.entity.CategoriasEntity
import com.teamkode.smartlist.domain.Anotacao
import com.teamkode.smartlist.domain.AnotacaoDetalhada
import com.teamkode.smartlist.domain.Categorias
import kotlinx.coroutines.flow.Flow

interface CategoriasRepository {

    suspend fun insertCategoria(item: Categorias)

    suspend fun deleteCategoria(item: Categorias)

    fun getAllCategorias(): Flow<List<Categorias>>

    suspend fun getCategoriaById(itemId: Int): Categorias?

    suspend fun getCategoriaByText(texto: String): List<Categorias>

}