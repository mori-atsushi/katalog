package jp.co.cyberagent.katalog

import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.compose.App
import jp.co.cyberagent.katalog.domain.KatalogDefaults
import jp.co.cyberagent.katalog.domain.KatalogDefinition
import jp.co.cyberagent.katalog.domain.SimpleKatalogContainer
import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.ext.KatalogExt

@Composable
public fun KatalogApp() {
    App()
}

@Composable
public fun KatalogApp(
    title: String = KatalogDefaults.defaultTitle,
    extensions: List<KatalogExt> = emptyList(),
    groupDefinition: GroupDefinition
) {
    val definition = KatalogDefinition(
        title = title,
        extensions = extensions,
        groupDefinition = groupDefinition
    )
    val container = SimpleKatalogContainer(definition)

    App(
        container = container
    )
}
