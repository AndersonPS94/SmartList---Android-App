package com.teamkode.smartlist.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.teamkode.smartlist.ui.theme.AppShapes
import com.teamkode.smartlist.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenuCustom(
    placeholder: String,
    list: List<String>,
    shape: Shape
) {
    var dropDownExposed by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf(TextFieldValue(placeholder)) }

    ExposedDropdownMenuBox(
        expanded = dropDownExposed,
        onExpandedChange = {
            dropDownExposed = !dropDownExposed
        }
    ) {

        OutlinedTextField(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.tertiaryContainer)
                .fillMaxWidth()
                .menuAnchor(),
            value = textFieldValue,
            onValueChange = {

            },
            readOnly = true,
            placeholder = {
                Text(placeholder)
            },
            shape = shape,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = dropDownExposed)
            }
        )

        ExposedDropdownMenu(
            expanded = dropDownExposed,
            onDismissRequest = {
                dropDownExposed = false
            }
        ) {
            list.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(item)
                    },
                    onClick = {
                        textFieldValue = TextFieldValue(item)
                        dropDownExposed = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AutoTextDropDownPreview() {
    AppTheme {
        DropDownMenuCustom(
            placeholder = "",
            list = listOf(),
            shape = AppShapes.small)
    }
}