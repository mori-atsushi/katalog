package jp.co.cyberagent.katalog.dsl

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.moriatsushi.katalog.dsl.fragment as actualFragment

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "FragmentDefinition<T>",
        "com.moriatsushi.katalog.dsl.FragmentDefinition"
    )
)
public typealias FragmentDefinition<T> =
    com.moriatsushi.katalog.dsl.FragmentDefinition<T>

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "FragmentOnCreateListener<T>",
        "com.moriatsushi.katalog.dsl.FragmentOnCreateListener"
    )
)
public typealias FragmentOnCreateListener<T> =
    com.moriatsushi.katalog.dsl.FragmentOnCreateListener<T>

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "fragment(name, layoutParams, onCreateView, definition)",
        "com.moriatsushi.katalog.dsl.fragment"
    ),
)
public inline fun <reified T : Fragment> GroupScope.fragment(
    name: String? = null,
    layoutParams: ViewGroup.LayoutParams = MATCH_WIDTH_MATCH_HEIGHT,
    noinline onCreateView: FragmentOnCreateListener<T> = {},
    noinline definition: FragmentDefinition<T>
) {
    actualFragment(name, layoutParams, onCreateView, definition)
}
