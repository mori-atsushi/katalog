package jp.co.cyberagent.katalog.dsl

import androidx.compose.runtime.Composable

typealias CatalogDefinition = CatalogScope.() -> Unit
typealias GroupDefinition = GroupScope.() -> Unit
typealias ComposeDefinition = @Composable () -> Unit

@DslMarker
annotation class CatalogDslMarker
