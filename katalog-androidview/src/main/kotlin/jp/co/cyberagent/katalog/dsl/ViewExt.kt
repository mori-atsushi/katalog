package jp.co.cyberagent.katalog.dsl

import android.view.View
import android.view.ViewGroup
import com.moriatsushi.katalog.dsl.view as actualView

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "ViewDefinition<T>",
        "com.moriatsushi.katalog.dsl.ViewDefinition",
    ),
)
public typealias ViewDefinition<T> = com.moriatsushi.katalog.dsl.ViewDefinition<T>

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "WRAP_WIDTH_WRAP_HEIGHT",
        "com.moriatsushi.katalog.dsl.WRAP_WIDTH_WRAP_HEIGHT",
    ),
)
public val WRAP_WIDTH_WRAP_HEIGHT: ViewGroup.LayoutParams =
    com.moriatsushi.katalog.dsl.WRAP_WIDTH_WRAP_HEIGHT

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "WRAP_WIDTH_MATCH_HEIGHT",
        "com.moriatsushi.katalog.dsl.WRAP_WIDTH_MATCH_HEIGHT",
    ),
)
public val WRAP_WIDTH_MATCH_HEIGHT: ViewGroup.LayoutParams =
    com.moriatsushi.katalog.dsl.WRAP_WIDTH_MATCH_HEIGHT

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "MATCH_WIDTH_WRAP_HEIGHT",
        "com.moriatsushi.katalog.dsl.MATCH_WIDTH_WRAP_HEIGHT",
    ),
)
public val MATCH_WIDTH_WRAP_HEIGHT: ViewGroup.LayoutParams =
    com.moriatsushi.katalog.dsl.MATCH_WIDTH_WRAP_HEIGHT

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "MATCH_WIDTH_MATCH_HEIGHT",
        "com.moriatsushi.katalog.dsl.MATCH_WIDTH_MATCH_HEIGHT",
    ),
)
public val MATCH_WIDTH_MATCH_HEIGHT: ViewGroup.LayoutParams =
    com.moriatsushi.katalog.dsl.MATCH_WIDTH_MATCH_HEIGHT

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "view(name, layoutParams, definition)",
        "com.moriatsushi.katalog.dsl.view",
    ),
)
public inline fun <reified T : View> GroupScope.view(
    name: String? = null,
    layoutParams: ViewGroup.LayoutParams = WRAP_WIDTH_WRAP_HEIGHT,
    noinline definition: ViewDefinition<T>,
) {
    actualView(name, layoutParams, definition)
}
