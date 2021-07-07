package jp.co.cyberagent.katalog.dsl

@CatalogDslMarker
interface GroupScope {
    fun group(name: String, definition: GroupDefinition)
    fun group(vararg group: Group)
    fun compose(name: String, definition: ComposeDefinition)
}
