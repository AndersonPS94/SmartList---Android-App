package com.teamkode.smartlist.domain.usecase

import com.teamkode.smartlist.domain.model.ShoppingItem
import com.teamkode.smartlist.domain.repository.ShoppingItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllShoppingItemsUseCase @Inject constructor(
    private val repository: ShoppingItemRepository
) {
    operator fun invoke(): Flow<List<ShoppingItem>> {
        return repository.getAllShoppingItems()
    }
}