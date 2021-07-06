package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.dsl.ComposeDefinition
import jp.co.cyberagent.katalog.dsl.GroupDefinition

internal object Mapper {
    fun dslToModel(
        name: String,
        definition: GroupDefinition
    ): CatalogItem.Group {
        val groupScope = GroupScopeImpl()
        definition.invoke(groupScope)
        return CatalogItem.Group(
            name = name,
            items = groupScope.items
        )
    }

    fun dslToModel(
        name: String,
        definition: ComposeDefinition
    ): CatalogItem.Component {
        return CatalogItem.Component(
            name = name,
            definition = definition
        )
    }
}
