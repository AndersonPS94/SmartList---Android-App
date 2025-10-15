package com.teamkode.smartlist.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teamkode.smartlist.domain.Categorias
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriasDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategoria(item: Categorias)

    @Delete
    suspend fun deleteCategoria(item: Categorias)

    @Query("SELECT * FROM categoria")
    fun getAllCategoria(): Flow<List<Categorias>>

    @Query("SELECT * FROM categoria WHERE id = :itemId")
    suspend fun getCategoriaById(itemId: Int): Categorias?
}