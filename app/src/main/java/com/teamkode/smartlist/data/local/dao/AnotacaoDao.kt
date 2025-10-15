package com.teamkode.smartlist.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teamkode.smartlist.domain.Anotacao
import kotlinx.coroutines.flow.Flow

@Dao
interface AnotacaoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnotacao(item: Anotacao)

    @Delete
    suspend fun deleteAnotacao(item: Anotacao)

    @Query("SELECT * FROM anotacoes ORDER BY data DESC")
    fun getAllAnotacao(): Flow<List<Anotacao>>

    @Query("SELECT * FROM anotacoes WHERE id = :itemId")
    suspend fun getAnotacaoById(itemId: Int): Anotacao?
}