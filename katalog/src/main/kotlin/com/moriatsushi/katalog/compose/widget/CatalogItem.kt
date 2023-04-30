package com.moriatsushi.katalog.compose.widget

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.moriatsushi.katalog.compose.res.defaultCornerRadius

@Composable
internal fun CatalogItemWrapper(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val shape = RoundedCornerShape(defaultCornerRadius)
    Box(
        modifier
            .clip(shape)
            .border(
                width = 1.5.dp,
                color = MaterialTheme.colors.surface,
                shape = shape,
            ),
    ) {
        content()
    }
}
