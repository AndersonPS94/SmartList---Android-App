package com.teamkode.smartlist.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.teamkode.smartlist.ui.theme.AppTheme
import com.teamkode.smartlist.ui.view.addItemScreenView.AddItemScreen
import com.teamkode.smartlist.ui.view.categoriesScreenView.CategoriesScreen
import com.teamkode.smartlist.ui.view.homeScreenView.HomeScreen
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashScreen = installSplashScreen()

        var keepSplash = true
        splashScreen.setKeepOnScreenCondition { keepSplash }

        lifecycleScope.launchWhenCreated {
            delay(5000)
            keepSplash = false
        }

        setContent {
            AppTheme {
                HomeScreen({})
            }
        }
    }
}
