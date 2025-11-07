package com.teamkode.smartlist.domain.usecase

import com.teamkode.smartlist.domain.model.ShoppingItem
import com.teamkode.smartlist.domain.repository.ShoppingItemRepository
import javax.inject.Inject

class InsertShoppingItemUseCase @Inject constructor(
    private val repository: ShoppingItemRepository
){
    suspend operator fun invoke(item: ShoppingItem){

        repository.insertItem(item)
    }
}