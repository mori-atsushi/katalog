package jp.co.cyberagent.katalog.ext

import androidx.compose.runtime.Composable

interface ExtComponentWrapperScope {
    val content: @Composable () -> Unit
}
