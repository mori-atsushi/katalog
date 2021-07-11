package jp.co.cyberagent.katalog.ext.theme.internal

import androidx.compose.material.Surface
import jp.co.cyberagent.katalog.ext.KatalogExt
import jp.co.cyberagent.katalog.ext.theme.ThemeDefinition

internal fun createThemeExt(
    theme: ThemeDefinition
): KatalogExt {
    val builder = KatalogExt.Builder("Theme")
    builder.setComponentWrapper { content ->
        theme {
            Surface(content = content)
        }
    }
    return builder.build()
}
