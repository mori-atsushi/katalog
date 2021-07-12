package jp.co.cyberagent.katalog.ext

import jp.co.cyberagent.katalog.domain.ExtensionBuilderImpl

public interface KatalogExt {
    public companion object {
        @ExperimentalKatalogExtApi
        @Suppress("FunctionName")
        public fun Builder(name: String): ExtensionBuilder =
            ExtensionBuilderImpl(name)
    }

    @ExperimentalKatalogExtApi
    public val name: String

    @ExperimentalKatalogExtApi
    public val componentWrapper: ExtComponentWrapper?
        get() = null

    @ExperimentalKatalogExtApi
    public val rootWrapper: ExtRootWrapper?
        get() = null
}
