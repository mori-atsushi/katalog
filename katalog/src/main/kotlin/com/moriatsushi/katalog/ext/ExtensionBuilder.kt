package com.moriatsushi.katalog.ext

@ExperimentalKatalogExtApi
public interface ExtensionBuilder {
    public fun setComponentWrapper(wrapper: ExtComponentWrapper): ExtensionBuilder
    public fun setRootWrapper(wrapper: ExtRootWrapper): ExtensionBuilder
    public fun build(): KatalogExt
}
