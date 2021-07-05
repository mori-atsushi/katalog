package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.ext.ExtComponentWrapper
import jp.co.cyberagent.katalog.ext.ExtRootWrapper
import jp.co.cyberagent.katalog.ext.KatalogExt

internal data class Extensions(
    val list: List<KatalogExt>
) {
    val rootWrappers: List<ExtRootWrapper>
        get() = list.mapNotNull { it.rootWrapper }

    val componentWrappers: List<ExtComponentWrapper>
        get() = list.mapNotNull { it.componentWrapper }
}
