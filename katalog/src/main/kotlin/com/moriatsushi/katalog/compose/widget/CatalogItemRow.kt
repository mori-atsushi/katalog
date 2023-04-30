package com.moriatsushi.katalog.compose.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moriatsushi.katalog.compose.res.defaultPadding
import com.moriatsushi.katalog.domain.CatalogItem
import com.moriatsushi.katalog.domain.Extensions
import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.ExtNavState

@ExperimentalKatalogExtApi
@Composable
internal fun CatalogItemRow(
    item: CatalogItem,
    extensions: Extensions,
    extNavState: ExtNavState,
    onClick: (CatalogItem) -> Unit,
) {
    val icon = when (item) {
        is CatalogItem.Component -> Icons.Filled.Widgets
        is CatalogItem.Group -> Icons.Filled.Folder
    }
    Column(
        modifier = Modifier
            .clickable(onClick = { onClick(item) })
            .fillMaxWidth(),
    ) {
        ItemTitle(
            name = item.name,
            icon = icon,
        )
        when (item) {
            is CatalogItem.Component -> ComponentRow(
                component = item,
                extensions = extensions,
                extNavState = extNavState,
            )
            is CatalogItem.Group -> GroupRow(
                group = item,
                onClick = onClick,
                extensions = extensions,
                extNavState = extNavState,
            )
        }
        ItemDivider()
    }
}

@ExperimentalKatalogExtApi
@Composable
private fun GroupRow(
    group: CatalogItem.Group,
    extensions: Extensions,
    extNavState: ExtNavState,
    onClick: (CatalogItem) -> Unit,
) {
    CatalogItemCarousel(
        list = group.items,
        extensions = extensions,
        extNavState = extNavState,
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
    )
}

@OptIn(ExperimentalKatalogExtApi::class)
@Composable
private fun ComponentRow(
    component: CatalogItem.Component,
    extensions: Extensions,
    extNavState: ExtNavState,
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(horizontal = defaultPadding),
    ) {
        val width = if (maxWidth > 600.dp) {
            420.dp
        } else {
            maxWidth
        }
        CatalogItemWrapper(
            modifier = Modifier
                .width(width)
                .aspectRatio(16.0F / 9.0F),
        ) {
            Preview(
                definition = component.definition,
                extensions = extensions,
                extNavState = extNavState,
            )
        }
    }
}

@Composable
private fun ItemTitle(
    name: String,
    icon: ImageVector,
) {
    Row(
        modifier = Modifier
            .padding(vertical = 14.dp, horizontal = defaultPadding),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "More",
            tint = MaterialTheme.colors.onBackground.copy(alpha = 0.7F),
        )
        Text(
            text = name,
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = 8.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.8F),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
        )
        Icon(
            imageVector = Icons.Filled.ArrowForward,
            contentDescription = "More",
            tint = MaterialTheme.colors.onBackground.copy(alpha = 0.7F),
        )
    }
}

@Composable
private fun ItemDivider() {
    Divider(
        modifier = Modifier.padding(top = defaultPadding),
        color = MaterialTheme.colors.surface,
    )
}
