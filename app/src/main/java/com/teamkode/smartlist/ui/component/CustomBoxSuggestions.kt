package com.teamkode.smartlist.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.teamkode.smartlist.R
import com.teamkode.smartlist.ui.theme.AppShapes
import com.teamkode.smartlist.ui.theme.AppTheme

@Composable
fun CustomBoxSuggestions(
    modifier: Modifier = Modifier,
    title: String,
    icon: Int = R.drawable.ic_preview,
    shape: Shape = AppShapes.medium,
    color: Color = MaterialTheme.colorScheme.tertiaryContainer,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    fontWeight: FontWeight = FontWeight.W500,
    width: Dp = 100.dp
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
        Column(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                painter = painterResource(id = icon),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = null
            )

            Text(
                text = title,
                style = style,
                fontWeight = fontWeight,
            )
        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFE2E8F0)
@Composable
private fun CustomBoxSuggestionsPreview() {
    AppTheme {
        CustomBoxSuggestions(
            modifier = Modifier,
            title = "Café",
            icon = R.drawable.ic_preview,
            width = 100.dp
        )
    }
}