package com.teamkode.smartlist.ui.component

import android.R.attr.fontWeight
import android.R.attr.paddingStart
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamkode.smartlist.R
import com.teamkode.smartlist.ui.theme.AppTheme

@Composable
fun CustomTitle(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    style: TextStyle = MaterialTheme.typography.bodySmall,
    fontWeight: FontWeight = FontWeight.W500,
    fontSize: TextUnit = 19.sp,
    paddingStart: Dp = 1.dp,
    paddingEnd: Dp = 1.dp,
    paddingTop: Dp = 1.dp,
    paddingBottom: Dp = 1.dp,
) {

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = paddingStart,
                end = paddingEnd,
                top = paddingTop,
                bottom = paddingBottom
            ),
        text = stringResource(title),
        style = style,
        fontWeight = fontWeight,
        fontSize = fontSize
    )
}

@Preview(showBackground = true)
@Composable
private fun CustomTitlePreview() {
    AppTheme {
        CustomTitle(title = R.string.txt_sugestoes_inteligentes)
    }
}