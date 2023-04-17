package com.moriatsushi.katalog.compose.navigation

import com.moriatsushi.katalog.domain.CatalogItem

internal sealed class DiscoveryDestination : NavDestination {
    object Top : DiscoveryDestination()

    data class Group(
        val group: CatalogItem.Group
    ) : DiscoveryDestination()
}
