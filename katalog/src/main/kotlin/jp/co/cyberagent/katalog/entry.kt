package jp.co.cyberagent.katalog

import jp.co.cyberagent.katalog.domain.DefaultKatalogContainer
import jp.co.cyberagent.katalog.domain.KatalogDefaults
import jp.co.cyberagent.katalog.dsl.Group
import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.ext.KatalogExt

public fun registerKatalog(
    title: String = KatalogDefaults.defaultTitle,
    extensions: List<KatalogExt> = emptyList(),
    groupDefinition: GroupDefinition
) {
    DefaultKatalogContainer.instance.register(title, extensions, groupDefinition)
}

public fun group(name: String, definition: GroupDefinition): Group {
    return Group(name, definition)
}
