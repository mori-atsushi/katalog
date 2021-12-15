package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.ext.KatalogExt

internal fun dummyKatalog(
    title: String = "",
    extensions: List<KatalogExt> = emptyList(),
    groupDefinition: GroupDefinition = {}
): Katalog {
    val container = KatalogContainer()
    container.register(
        title = title,
        extensions = extensions,
        groupDefinition = groupDefinition
    )
    return container.create()
}
