package jp.co.cyberagent.katalog.dsl

@CatalogDslMarker
@Suppress("UnnecessaryAbstractClass")
interface GroupScope {
    fun group(name: String, definition: GroupDefinition)
    fun group(vararg group: Group)
    fun compose(name: String, definition: ComposeDefinition)
}
