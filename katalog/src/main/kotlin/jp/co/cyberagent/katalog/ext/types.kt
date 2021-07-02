package jp.co.cyberagent.katalog.ext

import androidx.compose.runtime.Composable

typealias ExtensionPreviewWrapper = @Composable (@Composable () -> Unit) -> Unit
