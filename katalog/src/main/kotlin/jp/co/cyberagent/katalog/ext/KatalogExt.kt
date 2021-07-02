package jp.co.cyberagent.katalog.ext

abstract class KatalogExt {
    abstract val name: String

    open val previewWrapper: ExtensionPreviewWrapper = {
        it()
    }
}
