package jp.co.cyberagent.katalog.compose.page

import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.compose.navigation.NavController
import jp.co.cyberagent.katalog.compose.navigation.NavDestination
import jp.co.cyberagent.katalog.compose.widget.CatalogItemList
import jp.co.cyberagent.katalog.domain.Catalog
import jp.co.cyberagent.katalog.domain.CatalogItem

@Composable
internal fun TopPage(
    catalog: Catalog?,
    navController: NavController<NavDestination>
) {
    if (catalog == null) {
        return
    }
    CatalogItemList(
        list = catalog.items,
        onClick = {
            if (it is CatalogItem.Group) {
                navController.push(NavDestination.Group(it))
            }
        }
    )
}
