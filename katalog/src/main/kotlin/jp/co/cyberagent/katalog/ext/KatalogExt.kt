package jp.co.cyberagent.katalog.ext

import androidx.compose.runtime.Composable

abstract class KatalogExt {
    abstract val name: String

    @Composable
    open fun PreviewWrapper(content: @Composable () -> Unit) {
        content()
    }
}
