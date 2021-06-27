package jp.co.cyberagent.katalog.dsl

import android.content.Context
import android.view.View
import android.view.ViewGroup
import jp.co.cyberagent.katalog.compose.mapper.ViewToCompose
import kotlin.reflect.KClass

typealias ViewDefinition<T> = (context: Context) -> T

val WRAP_WIDTH_WRAP_HEIGHT = ViewGroup.LayoutParams(
    ViewGroup.LayoutParams.WRAP_CONTENT,
    ViewGroup.LayoutParams.WRAP_CONTENT
)
val WRAP_WIDTH_MATCH_HEIGHT = ViewGroup.LayoutParams(
    ViewGroup.LayoutParams.WRAP_CONTENT,
    ViewGroup.LayoutParams.MATCH_PARENT
)
val MATCH_WIDTH_WRAP_HEIGHT = ViewGroup.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT,
    ViewGroup.LayoutParams.WRAP_CONTENT
)
val MATCH_WIDTH_MATCH_HEIGHT = ViewGroup.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT,
    ViewGroup.LayoutParams.MATCH_PARENT
)

inline fun <reified T : View> GroupScope.view(
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
    val paramsFactory = getParamsFactory()
    compose(displayName) {
        ViewToCompose(paramsFactory, layoutParams, definition)
    }
}
