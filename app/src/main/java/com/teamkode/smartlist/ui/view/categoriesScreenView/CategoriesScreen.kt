package com.teamkode.smartlist.ui.view.categoriesScreenView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teamkode.smartlist.R
import com.teamkode.smartlist.domain.Categorias
import com.teamkode.smartlist.ui.component.CategoryItem
import com.teamkode.smartlist.ui.component.CustomTitle
import com.teamkode.smartlist.ui.theme.AppTheme
import com.teamkode.smartlist.ui.theme.LightPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(onClick: (Int) -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(stringResource(R.string.txt_categorias))
                    },
                    navigationIcon = {
                        Icon(
                            modifier = Modifier.padding(start = 20.dp),
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                    shape = RoundedCornerShape(30.dp),
                    containerColor = LightPrimary
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource(R.string.txt_adicionar_item)
                    )
                }
            }
        ) { paddingValues ->
            CategotiesContent(
                modifier = Modifier
                    .padding(top = paddingValues.calculateTopPadding()
                )
            ) {
                onClick(it)
            }
        }
    }
}

@Composable
fun CategotiesContent(modifier: Modifier = Modifier, onClick: (Int) -> Unit) {

    val listFake = mutableListOf(
        Categorias(
            id = 1,
            categoria = "Frutas"
        ),
        Categorias(
            id = 2,
            categoria = "Laticínios"
        ),
        Categorias(
            id = 3,
            categoria = "Higiene Pessoal"
        ),
        Categorias(
            id = 4,
            categoria = "Padaria"
        ),
        Categorias(
            id = 5,
            categoria = "Produtos de Limpezas"
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomTitle(title = R.string.txt_minhas_categorias)

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items( listFake) { items ->
                CategoryItem(
                    item = items.categoria,
                    iconStart = R.drawable.ic_preview,
                    iconEnd = R.drawable.ic_more_vert_24,
                    onCheckedChange = {}
                ) {
                    onClick(items.id.toInt())
                }
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun CategoriesScreenPreview() {
    AppTheme {
        CategoriesScreen({})
    }
}