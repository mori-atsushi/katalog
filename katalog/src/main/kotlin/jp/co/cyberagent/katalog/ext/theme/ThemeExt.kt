package jp.co.cyberagent.katalog.ext.theme

import jp.co.cyberagent.katalog.ext.ExtensionWrapper
import jp.co.cyberagent.katalog.ext.KatalogExt

internal class ThemeExt(
    private val theme: ThemeDefinition?
) : KatalogExt {
    override val name: String = "Theme"

    override val wrapper: ExtensionWrapper = {
        val theme = theme
        if (theme != null) {
            theme { it() }
        } else {
            it()
        }
    }
}
