package com.teamkode.smartlist.domain.usecase

import com.teamkode.smartlist.domain.model.ShoppingItem
import com.teamkode.smartlist.domain.repository.ShoppingItemRepository
import javax.inject.Inject

class ToggleItemPurchaseStatusUseCase @Inject constructor(
    private val repository: ShoppingItemRepository
){
    suspend operator fun invoke(item: ShoppingItem){
        val updatedItem = item.copy(isPurchased = !item.isPurchased)
        repository.updateItem(updatedItem)
    }
}