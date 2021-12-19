package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtComponentWrapper
import jp.co.cyberagent.katalog.ext.ExtRootWrapper
import jp.co.cyberagent.katalog.ext.KatalogExt

@OptIn(ExperimentalKatalogExtApi::class)
internal data class Extensions(
    val list: List<KatalogExt>
) {
    val rootWrappers: List<ExtRootWrapper> =
        list.mapNotNull { it.rootWrapper }

    val componentWrappers: List<ExtComponentWrapper> =
        list.mapNotNull { it.componentWrapper }
}
