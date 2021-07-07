package jp.co.cyberagent.katalog.ext

import jp.co.cyberagent.katalog.domain.ExtensionBuilderImpl

interface KatalogExt {
    companion object {
        @Suppress("FunctionName")
        fun Builder(name: String): ExtensionBuilder =
            ExtensionBuilderImpl(name)
    }

    val name: String

    val componentWrapper: ExtComponentWrapper?
        get() = null

    val rootWrapper: ExtRootWrapper?
        get() = null
}
