package jp.co.cyberagent.katalog.dsl

@CatalogDslMarker
abstract class KatalogScope : GroupScope() {
    abstract var title: String
    abstract var themeResId: Int?
}
