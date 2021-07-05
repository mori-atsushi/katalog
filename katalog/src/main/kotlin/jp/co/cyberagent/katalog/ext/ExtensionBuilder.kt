package jp.co.cyberagent.katalog.ext

interface ExtensionBuilder {
    fun setComponentWrapper(wrapper: ExtComponentWrapper)
    fun setRootWrapper(wrapper: ExtRootWrapper)
    fun build(): KatalogExt
}
