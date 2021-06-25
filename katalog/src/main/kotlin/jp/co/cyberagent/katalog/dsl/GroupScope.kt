package jp.co.cyberagent.katalog.dsl

import jp.co.cyberagent.katalog.domain.ParamsFactory

@CatalogDslMarker
@Suppress("UnnecessaryAbstractClass")
abstract class GroupScope {
    abstract fun group(name: String, definition: GroupDefinition)
    abstract fun group(vararg group: Group)
    abstract fun compose(name: String, definition: ComposeDefinition)

    internal abstract fun getParamsFactory(): ParamsFactory
}
