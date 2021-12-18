package jp.co.cyberagent.katalog.compose.navigation

import jp.co.cyberagent.katalog.domain.CatalogItem

internal fun NavController<MainDestination>.navigateTo(item: CatalogItem) {
    when (item) {
        is CatalogItem.Group -> {
            val currentDestination = current.destination
            val nextChildDestination = DiscoveryDestination.Group(item)
            if (currentDestination is MainDestination.Discovery) {
                currentDestination.childNavController.push(nextChildDestination)
            } else {
                val nextDestination = MainDestination.Discovery(
                    childNavController = NavController(nextChildDestination)
                )
                push(nextDestination)
            }
        }
        is CatalogItem.Component -> {
            val nextDestination = MainDestination.Preview(
                component = item
            )
            push(nextDestination)
        }
    }
}
