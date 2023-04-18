package com.moriatsushi.katalog.ext.theme

import androidx.compose.runtime.Composable

public typealias ThemeDefinition = @Composable (@Composable () -> Unit) -> Unit
