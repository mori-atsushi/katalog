package jp.co.cyberagent.katalog.compose.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import jp.co.cyberagent.katalog.domain.Katalog

internal val LocalKatalog = compositionLocalOf<Katalog> {
    error("require provide Katalog")
}

@Composable
internal fun KatalogLocalProvider(
    katalog: Katalog,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalKatalog provides katalog,
        content = content
    )
}
