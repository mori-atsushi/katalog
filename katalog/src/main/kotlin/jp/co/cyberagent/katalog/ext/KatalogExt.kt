package jp.co.cyberagent.katalog.ext

import jp.co.cyberagent.katalog.domain.ExtensionBuilderImpl

public interface KatalogExt {
    public companion object {
        @Suppress("FunctionName")
        public fun Builder(name: String): ExtensionBuilder =
            ExtensionBuilderImpl(name)
    }

    public val name: String

    public val componentWrapper: ExtComponentWrapper?
        get() = null

    public val rootWrapper: ExtRootWrapper?
        get() = null
}
