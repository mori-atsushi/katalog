package jp.co.cyberagent.katalog.dsl

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jp.co.cyberagent.katalog.androidview.mapper.FragmentToCompose
import kotlin.reflect.KClass

public typealias FragmentDefinition<T> = ViewDefinitionScope.() -> T
public typealias FragmentOnCreateListener<T> = ViewDefinitionScope.(fragment: T) -> Unit

public inline fun <reified T : Fragment> GroupScope.fragment(
    name: String? = null,
    layoutParams: ViewGroup.LayoutParams = MATCH_WIDTH_MATCH_HEIGHT,
    noinline onCreateView: FragmentOnCreateListener<T> = {},
    noinline definition: FragmentDefinition<T>
) {
    fragment(T::class, name, layoutParams, onCreateView, definition)
}

@PublishedApi
internal fun <T : Fragment> GroupScope.fragment(
    clazz: KClass<T>,
    name: String? = null,
    layoutParams: ViewGroup.LayoutParams = MATCH_WIDTH_MATCH_HEIGHT,
    onCreateView: FragmentOnCreateListener<T>,
    definition: FragmentDefinition<T>
) {
    val displayName = name ?: clazz.simpleName ?: ""
    compose(displayName) {
        FragmentToCompose(
            layoutParams = layoutParams,
            onCreateView = onCreateView,
            definition = definition
        )
    }
}
