package jp.co.cyberagent.katalog.compose.navigation

import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.CatalogItemIdentifier
import jp.co.cyberagent.katalog.domain.Katalog

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

internal fun NavController<MainDestination>.restore(
    katalog: Katalog,
    backStack: List<String>
): Boolean {
    val destinations = backStack.fold(listOf<MainDestination>()) { acc, it ->
        if (it == CatalogItemIdentifier.rootId) {
            val currentDestination = acc.firstOrNull()
            val nextChildDestination = DiscoveryDestination.Top
            if (currentDestination is MainDestination.Discovery) {
                currentDestination.childNavController.push(nextChildDestination)
                acc
            } else {
                val nextDestination = MainDestination.Discovery(
                    childNavController = NavController(nextChildDestination)
                )
                acc + nextDestination
            }
        } else {
            val item = katalog.findItemById(it, ignoreCount = true) ?: return false
            when (item) {
                is CatalogItem.Group -> {
                    val currentDestination = acc.firstOrNull()
                    val nextChildDestination = DiscoveryDestination.Group(item)
                    if (currentDestination is MainDestination.Discovery) {
                        currentDestination.childNavController.push(nextChildDestination)
                        acc
                    } else {
                        val nextDestination = MainDestination.Discovery(
                            childNavController = NavController(nextChildDestination)
                        )
                        acc + nextDestination
                    }
                }
                is CatalogItem.Component -> {
                    val nextDestination = MainDestination.Preview(
                        component = item
                    )
                    acc + nextDestination
                }
            }
        }
    }
    restore(destinations)
    return true
}
