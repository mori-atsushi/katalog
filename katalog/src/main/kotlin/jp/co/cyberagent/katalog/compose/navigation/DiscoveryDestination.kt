package jp.co.cyberagent.katalog.compose.navigation

import jp.co.cyberagent.katalog.domain.CatalogItem

internal sealed class DiscoveryDestination {
    object Top : DiscoveryDestination()

    data class Group(
        val group: CatalogItem.Group
    ) : DiscoveryDestination()
}
