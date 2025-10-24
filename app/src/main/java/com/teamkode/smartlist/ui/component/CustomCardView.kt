package com.teamkode.smartlist.ui.component

import android.R.attr.category
import android.R.attr.checked
import android.R.attr.onClick
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamkode.smartlist.R
import com.teamkode.smartlist.ui.theme.AppTheme

@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    category: String,
    @DrawableRes iconStart: Int,
    @DrawableRes iconEnd: Int? = null,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(painter = painterResource(iconStart), contentDescription = null)

            Spacer(Modifier.width(20.dp))

            Text(
                text = category,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400)

            Spacer(Modifier.weight(1f))

            if (iconEnd != null) {
                Image(painter = painterResource(iconEnd), contentDescription = null)
            } else {
                Checkbox(
                    modifier = Modifier.size(20.dp),
                    checked = checked,
                    onCheckedChange = onCheckedChange
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCardExampleScreen() {
    AppTheme {
        CustomCard(
            category = "Frutas",
            iconStart = R.drawable.ic_preview,
            iconEnd = null,
            checked = false,
            onCheckedChange = {},
            onClick = {}
        )
    }
}
