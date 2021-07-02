package jp.co.cyberagent.katalog.ext.theme

import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.ext.KatalogExt

internal class ThemeExt(
    private val theme: ThemeDefinition?
) : KatalogExt() {
    override val name: String = "Theme"

    @Composable
    override fun PreviewWrapper(content: () -> Unit) {
        val theme = theme
        if (theme != null) {
            theme { content() }
        } else {
            content()
        }
    }
}
