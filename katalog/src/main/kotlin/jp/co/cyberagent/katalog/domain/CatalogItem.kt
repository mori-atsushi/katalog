package jp.co.cyberagent.katalog.domain

import androidx.compose.runtime.Composable

internal sealed class CatalogItem {
    abstract val name: String

    data class Group(
        override val name: String,
        val items: List<CatalogItem>
    ) : CatalogItem()

    data class Component(
        override val name: String,
        val definition: @Composable () -> Unit
    ) : CatalogItem()
}
