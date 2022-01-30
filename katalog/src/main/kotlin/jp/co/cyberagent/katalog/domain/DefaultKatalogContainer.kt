package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.ext.KatalogExt

internal class DefaultKatalogContainer : KatalogContainer {
    companion object {
        val instance: DefaultKatalogContainer = DefaultKatalogContainer()
    }

    private var definition: KatalogDefinition? = null

    fun register(
        title: String,
        extensions: List<KatalogExt>,
        groupDefinition: GroupDefinition
    ) {
        if (definition != null) {
            throw AlreadyRegisteredException()
        }
        this.definition = KatalogDefinition(
            title = title,
            extensions = extensions,
            groupDefinition = groupDefinition
        )
    }

    override fun create(): Katalog {
        val definition = definition ?: throw NotRegisteredException()
        return definition.build()
    }
}
