package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState
import jp.co.cyberagent.katalog.ext.KatalogExt

@OptIn(ExperimentalKatalogExtApi::class)
internal data class KatalogDefinition(
    val title: String,
    val extensions: List<KatalogExt>,
    val groupDefinition: GroupDefinition
) {
    fun build(extNavState: ExtNavState): Katalog {
        val groupScope = GroupScopeImpl()
        groupScope.groupDefinition()
        return Katalog(
            title = title,
            items = groupScope.items,
            extensions = Extensions(
                extensions,
                ExtWrapperScopeImpl(
                    navState = extNavState
                )
            )
        )
    }
}
