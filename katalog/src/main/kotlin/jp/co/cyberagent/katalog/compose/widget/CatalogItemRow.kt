package jp.co.cyberagent.katalog.compose.widget

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
import jp.co.cyberagent.katalog.compose.res.defaultPadding
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.Extensions
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState

@ExperimentalKatalogExtApi
@Composable
internal fun CatalogItemRow(
    title: String,
    item: CatalogItem,
    extensions: Extensions,
    extNavState: ExtNavState,
    onClick: (CatalogItem) -> Unit
) {
    val icon = when (item) {
        is CatalogItem.Component -> Icons.Filled.Widgets
        is CatalogItem.Group -> Icons.Filled.Folder
    }
    Column(
        modifier = Modifier
            .clickable(onClick = { onClick(item) })
            .fillMaxWidth()
    ) {
        ItemTitle(
            name = item.name,
            icon = icon
        )
        when (item) {
            is CatalogItem.Component -> ComponentRow(
                title = title,
                component = item,
                extensions = extensions,
                extNavState = extNavState
            )
            is CatalogItem.Group -> GroupRow(
                title = title,
                group = item,
                onClick = onClick,
                extensions = extensions,
                extNavState = extNavState
            )
        }
        ItemDivider()
    }
}

@ExperimentalKatalogExtApi
@Composable
private fun GroupRow(
    title: String,
    group: CatalogItem.Group,
    extensions: Extensions,
    extNavState: ExtNavState,
    onClick: (CatalogItem) -> Unit
) {
    CatalogItemCarousel(
        title = title,
        list = group.items,
        extensions = extensions,
        extNavState = extNavState,
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalKatalogExtApi::class)
@Composable
private fun ComponentRow(
    title: String,
    component: CatalogItem.Component,
    extensions: Extensions,
    extNavState: ExtNavState
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(horizontal = defaultPadding)
    ) {
        val width = if (maxWidth > 600.dp) {
            420.dp
        } else {
            maxWidth
        }
        CatalogItemWrapper(
            modifier = Modifier
                .width(width)
                .aspectRatio(16.0F / 9.0F)
        ) {
            Preview(
                title = title,
                definition = component.definition,
                extensions = extensions,
                extNavState = extNavState
            )
        }
    }
}

@Composable
private fun ItemTitle(
    name: String,
    icon: ImageVector
) {
    Row(
        modifier = Modifier
            .padding(vertical = 14.dp, horizontal = defaultPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "More",
            tint = MaterialTheme.colors.onBackground.copy(alpha = 0.7F)
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
            fontWeight = FontWeight.Medium
        )
        Icon(
            imageVector = Icons.Filled.ArrowForward,
            contentDescription = "More",
            tint = MaterialTheme.colors.onBackground.copy(alpha = 0.7F)
        )
    }
}

@Composable
private fun ItemDivider() {
    Divider(
        modifier = Modifier.padding(top = defaultPadding),
        color = MaterialTheme.colors.surface
    )
}
