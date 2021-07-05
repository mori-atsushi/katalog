package jp.co.cyberagent.katalog.compose.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jp.co.cyberagent.katalog.compose.res.defaultPadding
import jp.co.cyberagent.katalog.domain.CatalogItem

@Composable
internal fun CatalogItemRow(
    item: CatalogItem,
    onClick: (CatalogItem) -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(onClick = { onClick(item) })
            .fillMaxWidth()
    ) {
        ItemTitle(name = item.name)
        when (item) {
            is CatalogItem.Component -> ComponentRow(
                component = item
            )
            is CatalogItem.Group -> GroupRow(
                group = item,
                onClick = onClick
            )
        }
        ItemDivider()
    }
}

@Composable
private fun GroupRow(
    group: CatalogItem.Group,
    onClick: (CatalogItem) -> Unit
) {
    CatalogItemCarousel(
        list = group.items,
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun ComponentRow(
    component: CatalogItem.Component
) {
    CatalogItemWrapper(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16.0F / 9.0F)
            .padding(horizontal = defaultPadding)
    ) {
        Preview(
            definition = component.definition
        )
    }
}

@Composable
private fun ItemTitle(name: String) {
    Text(
        text = name,
        modifier = Modifier
            .padding(top = defaultPadding, bottom = 12.dp)
            .padding(horizontal = defaultPadding),
        color = MaterialTheme.colors.onBackground,
        fontSize = 16.sp
    )
}

@Composable
private fun ItemDivider() {
    Divider(
        modifier = Modifier.padding(top = defaultPadding),
        color = MaterialTheme.colors.surface
    )
}
