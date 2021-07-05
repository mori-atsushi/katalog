package jp.co.cyberagent.katalog.ext.theme

import jp.co.cyberagent.katalog.dsl.ExtensionScope

fun ExtensionScope.theme(theme: ThemeDefinition) {
    add(createThemeExt(theme))
}
