package com.teamkode.smartlist.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teamkode.smartlist.R
import com.teamkode.smartlist.ui.theme.AppShapes
import com.teamkode.smartlist.ui.theme.AppTheme

@Composable
fun CustomTextField(
    modifier: Modifier,
    value: String,
    @StringRes placeable: Int,
    shape: Shape,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions,
    leadingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.tertiaryContainer),
        value = value,
        placeholder = {
            Text(stringResource(placeable))
        },
        shape = shape,
        maxLines = maxLines,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        onValueChange = onValueChange
    )
}

@Preview(showBackground = true)
@Composable
private fun CustomTextFieldPreview() {
    AppTheme {
        CustomTextField(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            value = "Uva",
            placeable = R.string.app_name,
            shape = AppShapes.medium,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            onValueChange = {}
        )
    }

}