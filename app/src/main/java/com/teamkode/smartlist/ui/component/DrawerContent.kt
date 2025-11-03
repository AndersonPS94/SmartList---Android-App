package com.teamkode.smartlist.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.teamkode.smartlist.ui.navigation.Screen

@Composable
fun DrawerContent(onNavigate: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Lista Inteligente", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onNavigate(Screen.ShoppingList.route) }) {
            Text("Criar Lista de Compras")
        }
        TextButton(onClick = { onNavigate(Screen.Settings.route) }) { Text("Configurações") }
        TextButton(onClick = { onNavigate(Screen.About.route) }) { Text("Sobre o App") }
    }
}
