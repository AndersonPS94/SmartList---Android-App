package com.teamkode.smartlist.data.repository

import com.teamkode.smartlist.data.local.dao.CategoriasDao
import com.teamkode.smartlist.data.local.entity.CategoriasEntity
import com.teamkode.smartlist.data.mapper.toEntity
import com.teamkode.smartlist.data.mapper.toModel
import com.teamkode.smartlist.domain.Categorias
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CategoriasRepositoryImpl(private val categoriasDao: CategoriasDao): CategoriasRepository {
    override suspend fun insertCategoria(item: Categorias) {
        categoriasDao.insertCategoria(item.toEntity())
    }

    override suspend fun deleteCategoria(item: Categorias) {
      categoriasDao.deleteCategoria(item.toEntity())
    }

    override fun getAllCategorias(): Flow<List<Categorias>> {
     return  categoriasDao.getAllCategoria().map { categoriaEntitys->
        categoriaEntitys.map { it.toModel() }
     }
    }

    override suspend fun getCategoriaById(itemId: Int): Categorias? {
      return  categoriasDao.getCategoriaById(itemId)?.toModel()
    }

    override suspend fun getCategoriaByText(texto: String): List<Categorias> {
      return categoriasDao.getCategoriaByText(texto).map { categoriaEntitys->
          categoriaEntitys.toModel()
      }
    }
}