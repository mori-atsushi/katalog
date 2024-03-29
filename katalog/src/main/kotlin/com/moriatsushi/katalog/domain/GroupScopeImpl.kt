package com.moriatsushi.katalog.domain

import com.moriatsushi.katalog.dsl.ComposeDefinition
import com.moriatsushi.katalog.dsl.Group
import com.moriatsushi.katalog.dsl.GroupDefinition
import com.moriatsushi.katalog.dsl.GroupScope

internal class GroupScopeImpl(
    private val parentIdentifier: CatalogItemIdentifier? = null,
) : GroupScope {
    private var _items = mutableListOf<CatalogItem>()
    val items: List<CatalogItem> get() = _items

    override fun group(name: String, definition: GroupDefinition) {
        val item = dslToModel(
            name = name,
            definition = definition,
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
        definition: ComposeDefinition,
    ) {
        val item = dslToModel(name, definition)
        _items.add(item)
    }

    private fun dslToModel(
        name: String,
        definition: GroupDefinition,
    ): CatalogItem.Group {
        val identifier = createIdentifier(name)
        val groupScope = GroupScopeImpl(identifier)
        definition.invoke(groupScope)
        return CatalogItem.Group(
            identifier = identifier,
            items = groupScope.items,
        )
    }

    private fun dslToModel(
        name: String,
        definition: ComposeDefinition,
    ): CatalogItem.Component {
        val identifier = createIdentifier(name)
        return CatalogItem.Component(
            identifier = identifier,
            definition = definition,
        )
    }

    private fun createIdentifier(name: String): CatalogItemIdentifier {
        return CatalogItemIdentifier.of(
            parent = parentIdentifier,
            name = name,
            count = items.count {
                it.name == name
            },
        )
    }
}
