package com.teamkode.smartlist.di

import com.teamkode.smartlist.data.local.database.ShoppingListDatabase
import com.teamkode.smartlist.data.repository.ShoppingItemRepositoryImpl
import com.teamkode.smartlist.domain.repository.ShoppingItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideShoppingItemRepository(db: ShoppingListDatabase) : ShoppingItemRepository {
        return ShoppingItemRepositoryImpl(db.shoppingItemDao())
    }
}