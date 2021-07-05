package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.dsl.ExtensionScope
import jp.co.cyberagent.katalog.ext.KatalogExt

internal class ExtensionScopeImpl : ExtensionScope {
    private val list = mutableListOf<KatalogExt>()

    override fun add(ext: KatalogExt) {
        list.add(ext)
    }

    fun build(): Extensions {
        return Extensions(list)
    }
}
