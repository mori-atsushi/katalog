package jp.co.cyberagent.katalog.ext.theme

import androidx.compose.runtime.Composable

typealias ThemeDefinition = @Composable (@Composable () -> Unit) -> Unit
