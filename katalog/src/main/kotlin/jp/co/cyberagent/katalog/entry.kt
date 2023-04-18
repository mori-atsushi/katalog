package jp.co.cyberagent.katalog

import com.moriatsushi.katalog.dsl.Group
import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.ext.KatalogExt

private const val DEFAULT_TITLE = "Katalog"

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "registerKatalog(title, extensions, groupDefinition)",
        "com.moriatsushi.katalog.registerKatalog"
    )
)
public fun registerKatalog(
    title: String = DEFAULT_TITLE,
    extensions: List<KatalogExt> = emptyList(),
    groupDefinition: GroupDefinition
) {
    com.moriatsushi.katalog.registerKatalog(
        title = title,
        extensions = extensions,
        groupDefinition = groupDefinition
    )
}

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "group(name, definition)",
        "com.moriatsushi.katalog.group"
    )
)
public fun group(name: String, definition: GroupDefinition): Group {
    return com.moriatsushi.katalog.group(
        name = name,
        definition = definition,
    )
}
