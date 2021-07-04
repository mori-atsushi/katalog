package jp.co.cyberagent.katalog.dsl

import jp.co.cyberagent.katalog.ext.KatalogExt

@CatalogDslMarker
interface KatalogScope : GroupScope {
    var title: String
    fun addExtension(ext: KatalogExt)
}
