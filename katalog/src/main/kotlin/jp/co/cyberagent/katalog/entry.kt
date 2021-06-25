package jp.co.cyberagent.katalog

import jp.co.cyberagent.katalog.domain.Catalog
import jp.co.cyberagent.katalog.dsl.CatalogDefinition
import jp.co.cyberagent.katalog.dsl.Group
import jp.co.cyberagent.katalog.dsl.GroupDefinition

fun startCatalog(definition: CatalogDefinition) {
    Catalog.register(definition)
}

fun group(name: String, definition: GroupDefinition): Group {
    return Group(name, definition)
}
