package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.dsl.ComposeDefinition
import jp.co.cyberagent.katalog.dsl.ExtensionDefinition
import jp.co.cyberagent.katalog.dsl.Group
import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.dsl.KatalogScope

internal class KatalogScopeImpl : KatalogScope {
    companion object {
        private const val DEFAULT_TITLE = "UI Catalog"
    }

    private val groupScope = GroupScopeImpl()
    private val extensionScope = ExtensionScopeImpl()

    override var title: String = DEFAULT_TITLE

    override fun group(name: String, definition: GroupDefinition) {
        groupScope.group(name, definition)
    }

    override fun group(vararg group: Group) {
        groupScope.group(*group)
    }

    override fun compose(name: String, definition: ComposeDefinition) {
        groupScope.compose(name, definition)
    }

    override fun extension(definition: ExtensionDefinition) {
        extensionScope.definition()
    }

    fun build(): Katalog {
        return Katalog(
            title = title,
            items = groupScope.items,
            extensions = extensionScope.build()
        )
    }
}
