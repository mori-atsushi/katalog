package jp.co.cyberagent.katalog.dsl

@CatalogDslMarker
public interface GroupScope {
    public fun group(name: String, definition: GroupDefinition)
    public fun group(vararg group: Group)
    public fun compose(name: String, definition: ComposeDefinition)
}
