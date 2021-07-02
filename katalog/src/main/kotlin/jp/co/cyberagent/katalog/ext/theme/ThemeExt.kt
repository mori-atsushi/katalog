package jp.co.cyberagent.katalog.ext.theme

import jp.co.cyberagent.katalog.ext.ExtensionPreviewWrapper
import jp.co.cyberagent.katalog.ext.KatalogExt

internal class ThemeExt(
    private val theme: ThemeDefinition?
) : KatalogExt() {
    override val name: String = "Theme"

    override val previewWrapper: ExtensionPreviewWrapper = {
        val theme = theme
        if (theme != null) {
            theme { it() }
        } else {
            it()
        }
    }
}
