package jp.co.cyberagent.katalog.dsl

@CatalogDslMarker
interface KatalogScope : GroupScope {
    var title: String
    fun extension(definition: ExtensionDefinition)
}
