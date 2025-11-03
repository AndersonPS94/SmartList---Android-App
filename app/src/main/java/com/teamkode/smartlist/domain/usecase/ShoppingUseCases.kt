package com.teamkode.smartlist.domain.usecase

import com.teamkode.smartlist.domain.model.Category
import com.teamkode.smartlist.domain.model.ShoppingItem
import com.teamkode.smartlist.domain.repository.CategoryRepository
import com.teamkode.smartlist.domain.repository.ShoppingItemRepository

data class ShoppingUseCases(
    val getShoppingItems: GetShoppingItems,
    val insertShoppingItem: InsertShoppingItem,
    val deleteShoppingItem: DeleteShoppingItem,
    val togglePurchasedStatus: TogglePurchasedStatus,
    val getCategories: GetCategories,
    val insertCategory: InsertCategory,
    val deleteCategory: DeleteCategory
)


class GetShoppingItems(private val repository: ShoppingItemRepository ){
    operator fun invoke() = repository.getAllShoppingItems()
}

class InsertShoppingItem (private val repository: ShoppingItemRepository){
    suspend operator fun invoke(item: ShoppingItem) = repository.insertShoppingItem(item)
}

class DeleteShoppingItem(private val repository: ShoppingItemRepository) {
    suspend operator fun invoke(item: ShoppingItem) {
        repository.deleteShoppingItem(item)
    }
}

class TogglePurchasedStatus(private val repository: ShoppingItemRepository) {
    suspend operator fun invoke(itemId: Int, isPurchased: Boolean) {
        repository.togglePurchasedStatus(itemId, isPurchased)
    }
}


class GetCategories(private val repository: CategoryRepository) {
    operator fun invoke() = repository.getAllCategories()
}

class InsertCategory(private val repository: CategoryRepository) {
    suspend operator fun invoke(category: Category) {
        if (category.name.isBlank()) {
            throw IllegalArgumentException("O nome da categoria não pode ser vazio.")
        }
        repository.insertCategory(category)
    }
}

class DeleteCategory(private val repository: CategoryRepository) {
    suspend operator fun invoke(category:Category) {
        repository.deleteCategory(category)
    }
}