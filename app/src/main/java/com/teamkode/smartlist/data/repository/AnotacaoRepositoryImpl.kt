package com.teamkode.smartlist.data.repository

import com.teamkode.smartlist.data.local.dao.AnotacaoDao
import com.teamkode.smartlist.data.mapper.toAnotacaoDetalhada
import com.teamkode.smartlist.data.mapper.toEntity
import com.teamkode.smartlist.domain.Anotacao
import com.teamkode.smartlist.domain.AnotacaoDetalhada
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AnotacaoRepositoryImpl(private val anotacaoDao: AnotacaoDao):AnotacaoRepository {
    override suspend fun insertAnotacao(item: Anotacao) {
        anotacaoDao.insertAnotacao(item.toEntity())
    }

    override suspend fun deleteAnotacao(item: Anotacao) {
        anotacaoDao.deleteAnotacao(item.toEntity())
    }

    override fun getAllAnotacoes(): Flow<List<AnotacaoDetalhada>> {
      return  anotacaoDao.getAllAnotacao().map { anotacoes->
          anotacoes.map { it.toAnotacaoDetalhada() }
      }
    }

    override suspend fun getAnotacaoByText(texto: String): List<AnotacaoDetalhada> {
       return anotacaoDao.getAnotacaoByText(texto).map { anotacoes->
           anotacoes.toAnotacaoDetalhada()
       }
    }

    override suspend fun getAnotacaoById(itemId: Int): AnotacaoDetalhada {
      return  anotacaoDao.getAnotacaoById(itemId).toAnotacaoDetalhada()
    }

    override fun getAnotacaoComCategoria(): Flow<List<AnotacaoDetalhada>> {
       return anotacaoDao.getAnotacaoComCategoria().map {anotacoes->
           anotacoes.map { it.toAnotacaoDetalhada() }
       }
    }

}