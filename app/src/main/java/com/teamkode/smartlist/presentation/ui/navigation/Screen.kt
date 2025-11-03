package com.teamkode.smartlist.presentation.ui.navigation

sealed class Screen(val route: String) {
    object ShoppingList : Screen("shopping_list")
    object Categories : Screen("categories")
    object AddItem : Screen("add_item")
    object Settings : Screen("settings")
    object About : Screen("about")
}