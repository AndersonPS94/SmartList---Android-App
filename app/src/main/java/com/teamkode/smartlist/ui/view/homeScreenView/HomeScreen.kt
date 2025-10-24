package com.teamkode.smartlist.ui.view.homeScreenView

import android.R.attr.onClick
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamkode.smartlist.R
import com.teamkode.smartlist.domain.Categorias
import com.teamkode.smartlist.ui.component.CategoryItem
import com.teamkode.smartlist.ui.component.CustomBox
import com.teamkode.smartlist.ui.component.CustomBoxSuggestions
import com.teamkode.smartlist.ui.component.CustomTextField
import com.teamkode.smartlist.ui.component.CustomTitle
import com.teamkode.smartlist.ui.theme.AppShapes
import com.teamkode.smartlist.ui.theme.AppTheme
import com.teamkode.smartlist.ui.theme.LightPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onClick: (Int) -> Unit) {
    AppTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(stringResource(R.string.txt_lista_de_compras))
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
                            imageVector = Icons.Rounded.Add,
                            contentDescription = null,
                        )
                    }
                }

            ) { paddingValues ->
                HomeScreenContent(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = paddingValues.calculateTopPadding())
                ) {
                    onClick(it)
                }
            }
        }

    }

}

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier, onClick: (Int) -> Unit) {
    var search by remember { mutableStateOf("") }
    val weekFilter = stringArrayResource(R.array.array_week_filter)
    val selectedWeekFilter by remember { mutableStateOf(weekFilter) }
    val context = LocalContext.current
    val scrollState1 = rememberScrollState()
    val scrollState2 = rememberScrollState()

    val listFake = mutableListOf(
        Categorias(
            id = 1,
            categoria = "Maçãs"
        ),
        Categorias(
            id = 2,
            categoria = "Leite"
        ),
        Categorias(
            id = 3,
            categoria = "Pão"
        ),
        Categorias(
            id = 4,
            categoria = "Ovos"
        ),
        Categorias(
            id = 5,
            categoria = "Suco de Laranja"
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CustomTextField(
                modifier = Modifier
                    .weight(1f),
                value = search,
                shape = AppShapes.small,
                placeable = R.string.txt_buscar_itens,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            ) {
                search = it
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .size(55.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = AppShapes.small
                    )
                    .clickable(onClick = {
                        Toast.makeText(context, "Clicou", Toast.LENGTH_SHORT).show()
                    }),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_filter_list),
                    contentDescription = null
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .horizontalScroll(scrollState1),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            CustomBox(title = selectedWeekFilter[0])
            CustomBox(title = selectedWeekFilter[1])
            CustomBox(title = selectedWeekFilter[2], width = 120.dp)
            CustomBox(title = selectedWeekFilter[3], width = 120.dp)
        }

        CustomTitle(
            paddingTop = 15.dp,
            paddingStart = 20.dp,
            paddingEnd = 20.dp,
            title = R.string.txt_sugestoes_inteligentes)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .horizontalScroll(scrollState2),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CustomBoxSuggestions(title = "Café")
            CustomBoxSuggestions(title = "Queijo")
            CustomBoxSuggestions(title = "Melancia")
            CustomBoxSuggestions(title = "Macarrão")
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            items( listFake) { items ->
                CategoryItem(
                    item = items.categoria,
                    iconStart = R.drawable.ic_preview,
                    iconEnd = null,
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
private fun HomeScreenPreview() {
    AppTheme() {
        HomeScreen({})
    }
}