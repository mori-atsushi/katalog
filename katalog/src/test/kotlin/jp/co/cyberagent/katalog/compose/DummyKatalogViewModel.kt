package jp.co.cyberagent.katalog.compose

import jp.co.cyberagent.katalog.domain.KatalogContainer
import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.ext.KatalogExt

internal fun dummyKatalogViewModel(
    title: String = "",
    extensions: List<KatalogExt> = emptyList(),
    groupDefinition: GroupDefinition = {}
): KatalogViewModel {
    val container = KatalogContainer()
    container.register(
        title = title,
        extensions = extensions,
        groupDefinition = groupDefinition
    )
    return KatalogViewModel(container)
}
