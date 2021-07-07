package jp.co.cyberagent.katalog.ext

import androidx.compose.runtime.Composable

public typealias ExtComponentWrapper = @Composable (@Composable () -> Unit) -> Unit
public typealias ExtRootWrapper = @Composable (@Composable () -> Unit) -> Unit
