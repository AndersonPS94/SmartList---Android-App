package com.teamkode.smartlist.domain.usecase

import com.teamkode.smartlist.domain.model.ShoppingItem
import com.teamkode.smartlist.domain.repository.ShoppingItemRepository
import javax.inject.Inject

class DeleteShoppingItemUseCase @Inject constructor(
    private val shoppingItemRepository: ShoppingItemRepository
) {
    suspend operator fun invoke(item: ShoppingItem) {
        shoppingItemRepository.deleteShoppingItem(item)
    }
}


