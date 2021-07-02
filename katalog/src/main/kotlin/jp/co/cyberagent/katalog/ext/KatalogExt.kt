package jp.co.cyberagent.katalog.ext

interface KatalogExt {
    val name: String

    val wrapper: ExtensionWrapper
        get() = { it() }
}
