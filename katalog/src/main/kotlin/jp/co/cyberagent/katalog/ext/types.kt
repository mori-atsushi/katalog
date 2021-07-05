package jp.co.cyberagent.katalog.ext

import androidx.compose.runtime.Composable

typealias ExtComponentWrapper = @Composable (@Composable () -> Unit) -> Unit
typealias ExtRootWrapper = @Composable (@Composable () -> Unit) -> Unit
