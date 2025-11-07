package com.teamkode.smartlist.domain.repository

import com.teamkode.smartlist.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getAllCategories(): Flow<List<Category>>
    suspend fun getCategoryById(id: Int): Category?
    suspend fun insertCategory(category: Category)
    suspend fun deleteCategory(category: Category)
}