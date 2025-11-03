package com.teamkode.smartlist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.teamkode.smartlist.ui.screens.*

@Composable
fun SmartListNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.ShoppingList.route,
        modifier = modifier
    ) {
        composable(Screen.ShoppingList.route) {
            ShoppingListScreen(
                onOpenCategories = { navController.navigate(Screen.Categories.route) },
                onOpenSettings = { navController.navigate(Screen.Settings.route) },
                onOpenAbout = { navController.navigate(Screen.About.route) }
            )
        }
        composable(Screen.Categories.route) { CategoryScreen() }
        composable(Screen.AddItem.route) { AddItemScreen(onSave = { navController.popBackStack() }) }
        composable(Screen.Settings.route) { SettingsScreen() }
        composable(Screen.About.route) { AboutScreen() }
    }
}
