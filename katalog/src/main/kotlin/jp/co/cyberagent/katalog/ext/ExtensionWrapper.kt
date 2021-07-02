package jp.co.cyberagent.katalog.ext

import androidx.compose.runtime.Composable

typealias ExtensionWrapper = @Composable (@Composable () -> Unit) -> Unit
