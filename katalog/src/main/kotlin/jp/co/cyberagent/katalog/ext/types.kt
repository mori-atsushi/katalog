package jp.co.cyberagent.katalog.ext

import androidx.compose.runtime.Composable

typealias ExtComponentWrapper = @Composable ExtComponentWrapperScope.() -> Unit
typealias ExtRootWrapper = @Composable ExtRootWrapperScope.() -> Unit
