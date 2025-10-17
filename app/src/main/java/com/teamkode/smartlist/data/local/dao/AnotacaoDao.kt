package com.teamkode.smartlist.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.teamkode.smartlist.data.local.entity.AnotacaoEntity
import com.teamkode.smartlist.data.local.relation.AnotacaoComCategoria
import com.teamkode.smartlist.domain.Anotacao
import kotlinx.coroutines.flow.Flow

@Dao
interface AnotacaoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnotacao(item: AnotacaoEntity)

    @Delete
    suspend fun deleteAnotacao(item: AnotacaoEntity)

    @Transaction
    @Query("SELECT * FROM anotacoes ORDER BY data DESC")
    fun getAllAnotacao(): Flow<List<AnotacaoComCategoria>>

    @Transaction
    @Query("SELECT * FROM anotacoes WHERE anotacao LIKE '%' || :texto || '%'")
    suspend fun getAnotacaoByText(texto:String): List<AnotacaoComCategoria>

    @Transaction
    @Query("SELECT * FROM anotacoes WHERE id = :itemId")
    suspend fun getAnotacaoById(itemId: Int): AnotacaoComCategoria

    @Transaction
    @Query("SELECT * FROM anotacoes")
    fun getAnotacaoComCategoria(): Flow<List<AnotacaoComCategoria>>
}