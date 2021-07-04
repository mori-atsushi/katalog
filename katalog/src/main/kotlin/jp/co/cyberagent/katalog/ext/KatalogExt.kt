package jp.co.cyberagent.katalog.ext

interface KatalogExt {
    val name: String

    val componentWrapper: ExtComponentWrapper?
        get() = null

    val rootWrapper: ExtRootWrapper?
        get() = null
}
