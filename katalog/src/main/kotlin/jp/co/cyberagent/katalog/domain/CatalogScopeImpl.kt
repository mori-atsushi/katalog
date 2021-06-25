package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.dsl.CatalogScope
import jp.co.cyberagent.katalog.dsl.ComposeDefinition
import jp.co.cyberagent.katalog.dsl.Group
import jp.co.cyberagent.katalog.dsl.GroupDefinition

internal class CatalogScopeImpl : CatalogScope() {
    companion object {
        private const val DEFAULT_TITLE = "UI Catalog"
    }

    private val paramsFactory = ParamsFactoryImpl()
    private val groupScope: GroupScopeImpl = GroupScopeImpl(
        paramsFactory = paramsFactory
    )

    override var title: String = DEFAULT_TITLE
    override var themeResId: Int? = null

    override fun group(name: String, definition: GroupDefinition) {
        groupScope.group(name, definition)
    }

    override fun group(vararg group: Group) {
        groupScope.group(*group)
    }

    override fun compose(name: String, definition: ComposeDefinition) {
        groupScope.compose(name, definition)
    }

    override fun getParamsFactory(): ParamsFactory {
        return paramsFactory
    }

    fun build(): Catalog {
        val params = Params(
            themeResId = themeResId
        )
        paramsFactory.setCatalogParams(params)
        return Catalog(
            title = title,
            items = groupScope.items
        )
    }
}
