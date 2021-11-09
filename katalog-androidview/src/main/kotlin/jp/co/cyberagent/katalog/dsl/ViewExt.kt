package jp.co.cyberagent.katalog.dsl

import android.view.View
import android.view.ViewGroup
import jp.co.cyberagent.katalog.androidview.mapper.ViewToCompose
import kotlin.reflect.KClass

public typealias ViewDefinition<T> = ViewDefinitionScope.() -> T

public val WRAP_WIDTH_WRAP_HEIGHT: ViewGroup.LayoutParams = ViewGroup.LayoutParams(
    ViewGroup.LayoutParams.WRAP_CONTENT,
    ViewGroup.LayoutParams.WRAP_CONTENT
)
public val WRAP_WIDTH_MATCH_HEIGHT: ViewGroup.LayoutParams = ViewGroup.LayoutParams(
    ViewGroup.LayoutParams.WRAP_CONTENT,
    ViewGroup.LayoutParams.MATCH_PARENT
)
public val MATCH_WIDTH_WRAP_HEIGHT: ViewGroup.LayoutParams = ViewGroup.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT,
    ViewGroup.LayoutParams.WRAP_CONTENT
)
public val MATCH_WIDTH_MATCH_HEIGHT: ViewGroup.LayoutParams = ViewGroup.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT,
    ViewGroup.LayoutParams.MATCH_PARENT
)

public inline fun <reified T : View> GroupScope.view(
    name: String? = null,
    layoutParams: ViewGroup.LayoutParams = WRAP_WIDTH_WRAP_HEIGHT,
    noinline definition: ViewDefinition<T>
) {
    view(T::class, name, layoutParams, definition)
}

@PublishedApi
internal fun <T : View> GroupScope.view(
    clazz: KClass<T>,
    name: String?,
    layoutParams: ViewGroup.LayoutParams,
    definition: ViewDefinition<T>
) {
    val displayName = name ?: clazz.simpleName ?: ""
    compose(displayName) {
        ViewToCompose(layoutParams, definition)
    }
}
