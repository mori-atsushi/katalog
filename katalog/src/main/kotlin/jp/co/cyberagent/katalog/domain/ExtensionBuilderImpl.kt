package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.ext.ExtComponentWrapper
import jp.co.cyberagent.katalog.ext.ExtRootWrapper
import jp.co.cyberagent.katalog.ext.ExtensionBuilder
import jp.co.cyberagent.katalog.ext.KatalogExt

internal class ExtensionBuilderImpl(
    private val name: String
) : ExtensionBuilder {
    private var componentWrapper: ExtComponentWrapper? = null
    private var rootWrapper: ExtRootWrapper? = null

    override fun setComponentWrapper(wrapper: ExtComponentWrapper) {
        this.componentWrapper = wrapper
    }

    override fun setRootWrapper(wrapper: ExtRootWrapper) {
        this.rootWrapper = wrapper
    }

    override fun build(): KatalogExt {
        return KatalogExtImpl(
            name = name,
            componentWrapper = componentWrapper,
            rootWrapper = rootWrapper
        )
    }
}
