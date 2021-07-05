package jp.co.cyberagent.katalog.compose.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jp.co.cyberagent.katalog.R
import jp.co.cyberagent.katalog.compose.res.defaultCornerRadius
import jp.co.cyberagent.katalog.compose.res.defaultPadding
import jp.co.cyberagent.katalog.domain.CatalogItem
import kotlin.math.ceil

private val spacing = 10.dp
private const val CONTENT_NUM = 2.05F

@Composable
internal fun CatalogItemCarousel(
    list: List<CatalogItem>,
    onClick: (CatalogItem) -> Unit,
    modifier: Modifier = Modifier
) {
    if (list.isEmpty()) {
        Empty()
        return
    }
    BoxWithConstraints(
        modifier = modifier
    ) {
        val spacingNum = (ceil(CONTENT_NUM).toInt() - 1)
        val contentWidth = maxWidth - defaultPadding * 2 - spacing * spacingNum
        val cellWidth = (contentWidth.value / CONTENT_NUM).dp
        LazyRow(
            contentPadding = PaddingValues(horizontal = defaultPadding)
        ) {
            itemsIndexed(list) { index, it ->
                val isLast = list.lastIndex == index
                val paddingEnd = if (isLast) 0.dp else spacing
                Cell(
                    modifier = Modifier
                        .padding(end = paddingEnd)
                        .width(cellWidth),
                    item = it,
                    onClick = { onClick(it) }
                )
            }
        }
    }
}

@Composable
private fun Cell(
    item: CatalogItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(defaultCornerRadius))
            .clickable(onClick = onClick)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .aspectRatio(1F)
                .clip(RoundedCornerShape(defaultCornerRadius)),
        ) {
            when (item) {
                is CatalogItem.Component -> {
                    ComponentCell(component = item)
                }
                is CatalogItem.Group -> {
                    GroupCell()
                }
            }
        }
        Text(
            text = item.name,
            modifier = Modifier
                .padding(top = 2.dp, bottom = 6.dp),
            fontSize = 12.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colors.onBackground
        )
    }
}

@Composable
private fun GroupCell() {
    CatalogItemWrapper(
        modifier = Modifier.fillMaxSize()
    ) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            val size = (maxWidth.value / 2.4).dp
            Icon(
                modifier = Modifier.size(size),
                painter = painterResource(R.drawable.catalog_icon_folder),
                tint = MaterialTheme.colors.onBackground.copy(alpha = 0.6F),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun ComponentCell(
    component: CatalogItem.Component
) {
    CatalogItemWrapper(
        modifier = Modifier.fillMaxSize()
    ) {
        Preview(
            scale = 0.5F,
            definition = component.definition
        )
    }
}
