package jp.co.cyberagent.katalog.dsl

@CatalogDslMarker
abstract class CatalogScope : GroupScope() {
    abstract var title: String
    abstract var themeResId: Int?
}
