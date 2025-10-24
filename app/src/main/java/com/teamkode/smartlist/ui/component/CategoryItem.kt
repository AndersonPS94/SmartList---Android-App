package com.teamkode.smartlist.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable

@Composable
fun CategoryItem(
    item: String,
    @DrawableRes iconStart: Int,
    @DrawableRes iconEnd: Int? = null,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit,
    onClick: () -> Unit,
) {
    CustomCard(
        category = item,
        iconStart = iconStart,
        iconEnd = iconEnd,
        checked = checked,
        onCheckedChange = onCheckedChange,
        onClick = onClick
    )
}