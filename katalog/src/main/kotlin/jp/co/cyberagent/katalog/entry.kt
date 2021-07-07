package jp.co.cyberagent.katalog

import jp.co.cyberagent.katalog.domain.Katalog
import jp.co.cyberagent.katalog.dsl.Group
import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.ext.KatalogExt

private const val DEFAULT_TITLE = "Katalog"

fun registerKatalog(
    title: String = DEFAULT_TITLE,
    extensions: List<KatalogExt> = emptyList(),
    groupDefinition: GroupDefinition
) {
    Katalog.register(title, extensions, groupDefinition)
}

fun group(name: String, definition: GroupDefinition): Group {
    return Group(name, definition)
}
