package com.teamkode.smartlist.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.teamkode.smartlist.ui.theme.AppShapes
import com.teamkode.smartlist.ui.theme.AppTheme

@Composable
fun CustomBox(
    modifier: Modifier = Modifier,
    title: String,
    color: Color = MaterialTheme.colorScheme.onTertiaryContainer,
    shape: Shape = AppShapes.large,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    fontWeight: FontWeight = FontWeight.W500,
    width: Dp = 90.dp
) {

    Box(
        modifier = Modifier
            .width(width = width)
            .background(
                color = color,
                shape = shape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = title,
            style = style,
            fontWeight = fontWeight,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CustomBoxPreview() {
    AppTheme {
        CustomBox(title = "Todos")
    }
}