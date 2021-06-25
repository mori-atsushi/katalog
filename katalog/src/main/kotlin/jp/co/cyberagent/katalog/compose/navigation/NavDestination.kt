package jp.co.cyberagent.katalog.compose.navigation

import jp.co.cyberagent.katalog.domain.CatalogItem

internal sealed class NavDestination {
    object Top : NavDestination()

    data class Group(
        val group: CatalogItem.Group
    ) : NavDestination()
}
