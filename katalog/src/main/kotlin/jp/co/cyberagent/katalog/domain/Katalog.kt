package jp.co.cyberagent.katalog.domain

internal data class Katalog(
    val title: String,
    val items: List<CatalogItem>,
    val extensions: Extensions
) {
    fun findItemById(id: String, ignoreCount: Boolean = false): CatalogItem? {
        val target = CatalogItemIdentifier.ofOrNull(id) ?: return null
        val items = target.parents.fold(items) { acc, name ->
            val result = acc.find {
                it.name == name
            }
            if (result is CatalogItem.Group) {
                result.items
            } else {
                return null
            }
        }
        val result = items.find {
            it.identifier == target
        }
        if (result != null || !ignoreCount) {
            return result
        }
        return items.find {
            it.identifier.equals(target, true)
        }
    }
}
