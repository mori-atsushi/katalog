package jp.co.cyberagent.katalog.ext

import androidx.compose.runtime.Composable

@ExperimentalKatalogExtApi
public typealias ExtComponentWrapper = @Composable ExtWrapperScope.(content: @Composable () -> Unit) -> Unit

@ExperimentalKatalogExtApi
public typealias ExtRootWrapper = @Composable ExtWrapperScope.(content: @Composable () -> Unit) -> Unit

@RequiresOptIn(message = "This is an experimental animation API.")
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.TYPEALIAS
)
public annotation class ExperimentalKatalogExtApi
