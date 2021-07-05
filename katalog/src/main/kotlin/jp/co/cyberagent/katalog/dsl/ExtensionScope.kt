package jp.co.cyberagent.katalog.dsl

import jp.co.cyberagent.katalog.ext.KatalogExt

@CatalogDslMarker
interface ExtensionScope {
    fun add(ext: KatalogExt)
}
