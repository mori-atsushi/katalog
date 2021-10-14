package jp.co.cyberagent.katalog.ext.theme.internal

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.KatalogExt
import jp.co.cyberagent.katalog.ext.theme.ThemeDefinition

@OptIn(ExperimentalKatalogExtApi::class)
internal fun createThemeExt(
    theme: ThemeDefinition
): KatalogExt {
    val builder = KatalogExt.Builder("Theme")
    builder.setComponentWrapper { content ->
        theme {
            Surface(
                color = MaterialTheme.colors.background,
                content = content
            )
        }
    }
    return builder.build()
}
