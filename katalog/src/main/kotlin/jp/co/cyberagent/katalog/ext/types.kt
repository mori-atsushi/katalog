package jp.co.cyberagent.katalog.ext

import androidx.compose.runtime.Composable

public typealias ExtComponentWrapper = @Composable (@Composable () -> Unit) -> Unit
public typealias ExtRootWrapper = @Composable (@Composable () -> Unit) -> Unit

@RequiresOptIn(message = "This is an experimental animation API.")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
public annotation class ExperimentalKatalogExtApi
