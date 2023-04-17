package com.moriatsushi.katalog.domain

import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.ExtComponentWrapper
import com.moriatsushi.katalog.ext.ExtRootWrapper
import com.moriatsushi.katalog.ext.ExtensionBuilder
import com.moriatsushi.katalog.ext.KatalogExt

@ExperimentalKatalogExtApi
internal class ExtensionBuilderImpl(
    private val name: String
) : ExtensionBuilder {
    private var componentWrapper: ExtComponentWrapper? = null
    private var rootWrapper: ExtRootWrapper? = null

    override fun setComponentWrapper(
        wrapper: ExtComponentWrapper
    ): ExtensionBuilder {
        this.componentWrapper = wrapper
        return this
    }

    override fun setRootWrapper(
        wrapper: ExtRootWrapper
    ): ExtensionBuilder {
        this.rootWrapper = wrapper
        return this
    }

    override fun build(): KatalogExt {
        return KatalogExtImpl(
            name = name,
            componentWrapper = componentWrapper,
            rootWrapper = rootWrapper
        )
    }
}
