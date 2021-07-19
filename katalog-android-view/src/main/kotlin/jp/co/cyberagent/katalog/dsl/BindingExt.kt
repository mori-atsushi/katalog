package jp.co.cyberagent.katalog.dsl

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import jp.co.cyberagent.katalog.android_view.mapper.BindingToCompose
import kotlin.reflect.KClass

public typealias BindingFactoryDefinition<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
public typealias BindingUpdateDefinition<T> = ViewDefinitionScope.(T) -> Unit

public inline fun <reified T : ViewBinding> GroupScope.binding(
    noinline factory: BindingFactoryDefinition<T>,
    name: String? = null,
    layoutParams: ViewGroup.LayoutParams = WRAP_WIDTH_WRAP_HEIGHT,
    noinline update: BindingUpdateDefinition<T> = {}
) {
    binding(T::class, factory, name, layoutParams, update)
}

@PublishedApi
internal fun <T : ViewBinding> GroupScope.binding(
    clazz: KClass<T>,
    factory: BindingFactoryDefinition<T>,
    name: String?,
    layoutParams: ViewGroup.LayoutParams = WRAP_WIDTH_WRAP_HEIGHT,
    update: BindingUpdateDefinition<T> = {}
) {
    val displayName = name ?: clazz.simpleName ?: ""
    compose(displayName) {
        BindingToCompose(factory, layoutParams, update)
    }
}
