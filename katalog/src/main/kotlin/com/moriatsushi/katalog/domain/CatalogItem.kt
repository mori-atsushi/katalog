package com.moriatsushi.katalog.domain

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
internal sealed class CatalogItem {
    abstract val identifier: CatalogItemIdentifier

    data class Group(
        override val identifier: CatalogItemIdentifier,
        val items: List<CatalogItem>
    ) : CatalogItem()

    data class Component(
        override val identifier: CatalogItemIdentifier,
        val definition: @Composable () -> Unit
    ) : CatalogItem()

    val name: String
        get() = identifier.name

    val id: String
        get() = identifier.id
}
