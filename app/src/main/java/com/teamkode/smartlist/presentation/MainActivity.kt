package com.teamkode.smartlist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.teamkode.smartlist.presentation.ui.component.DrawerContent
import com.teamkode.smartlist.presentation.ui.navigation.Screen
import com.teamkode.smartlist.presentation.ui.navigation.SmartListNavHost
import com.teamkode.smartlist.presentation.ui.theme.SmartListTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashScreen = installSplashScreen()
        var keepSplash = true
        splashScreen.setKeepOnScreenCondition { keepSplash }

        lifecycleScope.launchWhenCreated {
            delay(2000) // tempo do splash
            keepSplash = false
        }

        enableEdgeToEdge()

        setContent {
            SmartListTheme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        DrawerContent(
                            onNavigate = { route ->
                                scope.launch {
                                    drawerState.close()
                                    navController.navigate(route) {
                                        popUpTo(Screen.ShoppingList.route)
                                        launchSingleTop = true
                                    }
                                }
                            }
                        )
                    }
                ) {
                    Scaffold(
                        modifier = Modifier.Companion.fillMaxSize(),
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {
                                    navController.navigate(Screen.AddItem.route)
                                }
                            ) {
                                Icon(Icons.Default.Add, contentDescription = "Adicionar Item")
                            }
                        }
                    ) { innerPadding ->
                        SmartListNavHost(
                            navController = navController,
                            modifier = Modifier.Companion.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}