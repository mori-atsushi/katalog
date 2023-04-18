package com.moriatsushi.katalog.ext.theme.internal

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.KatalogExt
import com.moriatsushi.katalog.ext.theme.ThemeDefinition

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
