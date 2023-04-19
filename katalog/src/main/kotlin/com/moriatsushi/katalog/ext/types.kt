package com.moriatsushi.katalog.ext

import androidx.compose.runtime.Composable

@ExperimentalKatalogExtApi
public typealias ExtComponentWrapper = @Composable ExtWrapperScope.(content: @Composable () -> Unit) -> Unit

@ExperimentalKatalogExtApi
public typealias ExtRootWrapper = @Composable ExtWrapperScope.(content: @Composable () -> Unit) -> Unit

@RequiresOptIn(message = "This is an experimental katalog extension API.")
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.TYPEALIAS
)
@Retention(AnnotationRetention.BINARY)
public annotation class ExperimentalKatalogExtApi
