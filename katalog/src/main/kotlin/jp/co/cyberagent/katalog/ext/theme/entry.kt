package jp.co.cyberagent.katalog.ext.theme

import jp.co.cyberagent.katalog.dsl.KatalogScope

fun KatalogScope.theme(theme: ThemeDefinition) {
    addExtension(ThemeExt(theme))
}
