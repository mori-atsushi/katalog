package com.moriatsushi.katalog.compose.navigation

import com.moriatsushi.katalog.domain.CatalogItem

internal sealed class MainDestination : NavDestination {
    data class Discovery(
        override val childNavController: NavController<DiscoveryDestination>,
    ) : MainDestination()

    data class Preview(
        val component: CatalogItem.Component,
    ) : MainDestination()
}
