package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.dsl.ComposeDefinition
import jp.co.cyberagent.katalog.dsl.Group
import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.dsl.GroupScope

internal class GroupScopeImpl(
    private val paramsFactory: ParamsFactory
) : GroupScope() {
    private var _items = mutableListOf<CatalogItem>()
    val items: List<CatalogItem> get() = _items

    override fun group(name: String, definition: GroupDefinition) {
        val item = Mapper.dslToModel(
            name = name,
            definition = definition,
            paramsFactory = paramsFactory
        )
        _items.add(item)
    }

    override fun group(vararg group: Group) {
        group.forEach {
            group(it.name, it.definition)
        }
    }

    override fun compose(
        name: String,
        definition: ComposeDefinition
    ) {
        val item = Mapper.dslToModel(name, definition)
        _items.add(item)
    }

    override fun getParamsFactory(): ParamsFactory {
        return paramsFactory
    }
}
