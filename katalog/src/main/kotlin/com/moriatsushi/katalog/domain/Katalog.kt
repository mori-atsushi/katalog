package com.moriatsushi.katalog.domain

import androidx.compose.runtime.Stable

@Stable
internal data class Katalog(
    val title: String,
    val items: List<CatalogItem>,
    val extensions: Extensions,
) {
    fun findItemById(id: String, ignoreCount: Boolean = false): CatalogItem? {
        val identifier = CatalogItemIdentifier.ofOrNull(id) ?: return null
        val items = identifier.parents.fold(items) { acc, parent ->
            val result = findItem(acc, parent, ignoreCount)
            if (result is CatalogItem.Group) {
                result.items
            } else {
                return null
            }
        }
        return findItem(items, identifier, ignoreCount)
    }

    private fun findItem(
        items: List<CatalogItem>,
        identifier: CatalogItemIdentifier,
        ignoreCount: Boolean,
    ): CatalogItem? {
        val result = items.find {
            it.identifier.name == identifier.name && it.identifier.count == identifier.count
        }
        if (result != null || !ignoreCount) {
            return result
        }
        return items.find {
            it.identifier.name == identifier.name
        }
    }
}
