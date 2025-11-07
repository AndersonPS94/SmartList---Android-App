package com.teamkode.smartlist.ui.view.addItemScreenView

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamkode.smartlist.R
import com.teamkode.smartlist.ui.component.CustomTextField
import com.teamkode.smartlist.ui.component.DropDownMenuCustom
import com.teamkode.smartlist.ui.theme.AppShapes
import com.teamkode.smartlist.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen() {
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(stringResource(R.string.txt_adicionar_item))
                        }
                    )
                }
            ) { paddingValues ->
                AddItemContent(
                    modifier = Modifier.padding(top = paddingValues.calculateTopPadding())
                )
            }
        }
    }
}

@Composable
fun AddItemContent(
    modifier: Modifier,
) {
    val category = stringArrayResource(R.array.array_categories)
    val selectedCategory by remember { mutableStateOf(category) }
    var nameItem by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(R.string.txt_nome_do_item),
            Modifier.fillMaxWidth(),
            fontSize = 18.sp
        )

        CustomTextField(
            modifier = Modifier,
            value = nameItem,
            placeable = R.string.txt_o_que_voce_precisa_comprar,
            shape = AppShapes.small,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        ) {
            nameItem = it
        }

        Text(
            stringResource(R.string.txt_categorias),
            Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            fontSize = 18.sp
        )

        DropDownMenuCustom(
            placeholder = stringResource(R.string.txt_selecionar_categoria),
            list = category.toList(),
            shape = AppShapes.small
        )

        Column(
            modifier = Modifier.fillMaxSize()
                .navigationBarsPadding(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                onClick = {
                    Toast.makeText(context, "Item adicionado", Toast.LENGTH_LONG).show()
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    "Salvar Item",
                    color = MaterialTheme.colorScheme.background
                )
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun AddItemPreview() {
    AppTheme {
        AddItemScreen()
    }
}