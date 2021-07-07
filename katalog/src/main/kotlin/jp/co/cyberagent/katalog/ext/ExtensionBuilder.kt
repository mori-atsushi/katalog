package jp.co.cyberagent.katalog.ext

interface ExtensionBuilder {
    fun setComponentWrapper(wrapper: ExtComponentWrapper): ExtensionBuilder
    fun setRootWrapper(wrapper: ExtRootWrapper): ExtensionBuilder
    fun build(): KatalogExt
}
