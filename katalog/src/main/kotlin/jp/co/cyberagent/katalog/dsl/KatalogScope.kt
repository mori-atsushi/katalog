package jp.co.cyberagent.katalog.dsl

import jp.co.cyberagent.katalog.ext.KatalogExt

@CatalogDslMarker
abstract class KatalogScope : GroupScope() {
    abstract var title: String
    abstract var themeResId: Int?
    abstract fun addExtension(ext: KatalogExt)
}
