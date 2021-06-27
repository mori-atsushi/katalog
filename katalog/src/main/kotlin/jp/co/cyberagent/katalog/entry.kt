package jp.co.cyberagent.katalog

import jp.co.cyberagent.katalog.domain.Katalog
import jp.co.cyberagent.katalog.dsl.Group
import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.dsl.KatalogDefinition

fun startKatalog(definition: KatalogDefinition) {
    Katalog.register(definition)
}

fun group(name: String, definition: GroupDefinition): Group {
    return Group(name, definition)
}
