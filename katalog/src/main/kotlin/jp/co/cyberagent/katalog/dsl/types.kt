package jp.co.cyberagent.katalog.dsl

import androidx.compose.runtime.Composable

public typealias GroupDefinition = GroupScope.() -> Unit
public typealias ComposeDefinition = @Composable () -> Unit

@DslMarker
internal annotation class CatalogDslMarker
