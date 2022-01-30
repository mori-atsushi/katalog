package jp.co.cyberagent.katalog.domain

internal class SimpleKatalogContainer(
    private val definition: KatalogDefinition
) : KatalogContainer {
    override fun create(): Katalog {
        return definition.build()
    }
}
