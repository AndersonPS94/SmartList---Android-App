package com.teamkode.smartlist.presentation.di

import android.app.Application
import androidx.room.Room
import com.teamkode.smartlist.data.local.dao.CategoryDao
import com.teamkode.smartlist.data.local.dao.ShoppingItemDao
import com.teamkode.smartlist.data.local.database.ShoppingListDatabase
import com.teamkode.smartlist.data.repository.CategoryRepositoryImpl
import com.teamkode.smartlist.data.repository.ShoppingItemRepositoryImpl
import com.teamkode.smartlist.domain.repository.ShoppingItemRepository
import com.teamkode.smartlist.domain.usecase.DeleteCategory
import com.teamkode.smartlist.domain.usecase.DeleteShoppingItem
import com.teamkode.smartlist.domain.usecase.GetCategories
import com.teamkode.smartlist.domain.usecase.GetShoppingItems
import com.teamkode.smartlist.domain.usecase.InsertCategory
import com.teamkode.smartlist.domain.usecase.InsertShoppingItem
import com.teamkode.smartlist.domain.usecase.ShoppingUseCases
import com.teamkode.smartlist.domain.usecase.TogglePurchasedStatus

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Provedor do Database
    @Provides
    @Singleton
    fun provideShoppingListDatabase(app: Application): ShoppingListDatabase {
        return Room.databaseBuilder(
            app,
            ShoppingListDatabase::class.java,
            ShoppingListDatabase.DATABASE_NAME
        ).build()
    }

    // Provedores dos DAOs
    @Provides
    @Singleton
    fun provideShoppingItemDao(db: ShoppingListDatabase): ShoppingItemDao {
        return db.shoppingItemDao()
    }

    @Provides
    @Singleton
    fun provideCategoryDao(db: ShoppingListDatabase): CategoryDao {
        return db.categoryDao()
    }

    // Provedores dos Repositórios
    @Provides
    @Singleton
    fun provideShoppingItemRepository(dao: ShoppingItemDao): ShoppingItemRepository {
        return ShoppingItemRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(dao: CategoryDao): CategoryRepository {
        return CategoryRepositoryImpl(dao)
    }

    // Provedor dos Use Cases
    @Provides
    @Singleton
    fun provideShoppingUseCases(
        itemRepository: ShoppingItemRepository,
        categoryRepository: CategoryRepository
    ): ShoppingUseCases {
        return ShoppingUseCases(
            getShoppingItems = GetShoppingItems(itemRepository),
            insertShoppingItem = InsertShoppingItem(itemRepository),
            deleteShoppingItem = DeleteShoppingItem(itemRepository),
            togglePurchasedStatus = TogglePurchasedStatus(itemRepository),
            getCategories = GetCategories(categoryRepository),
            insertCategory = InsertCategory(categoryRepository),
            deleteCategory = DeleteCategory(categoryRepository)
        )
    }
}