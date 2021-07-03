package jp.co.cyberagent.katalog.ext.theme

import jp.co.cyberagent.katalog.ext.ExtComponentWrapper
import jp.co.cyberagent.katalog.ext.KatalogExt

internal class ThemeExt(
    private val theme: ThemeDefinition
) : KatalogExt {
    override val name: String = "Theme"

    override val componentWrapper: ExtComponentWrapper = {
        theme { it() }
    }
}
