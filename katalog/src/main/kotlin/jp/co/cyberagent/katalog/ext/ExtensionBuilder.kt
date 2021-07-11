package jp.co.cyberagent.katalog.ext

public interface ExtensionBuilder {
    public fun setComponentWrapper(wrapper: ExtComponentWrapper): ExtensionBuilder
    public fun setRootWrapper(wrapper: ExtRootWrapper): ExtensionBuilder
    public fun build(): KatalogExt
}
