package jp.co.cyberagent.katalog.ext

import androidx.compose.runtime.Composable

interface ExtRootWrapperScope {
    val content: @Composable () -> Unit
}
