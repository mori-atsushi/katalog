package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.dsl.ComposeDefinition
import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.dsl.KatalogDefinition

internal object Mapper {
    fun dslToModel(definition: KatalogDefinition): Katalog {
        val catalogScope = KatalogScopeImpl()
        definition.invoke(catalogScope)
        return catalogScope.build()
    }

    fun dslToModel(
        name: String,
        definition: GroupDefinition,
        paramsFactory: ParamsFactory
    ): CatalogItem.Group {
        val groupScope = GroupScopeImpl(paramsFactory)
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
