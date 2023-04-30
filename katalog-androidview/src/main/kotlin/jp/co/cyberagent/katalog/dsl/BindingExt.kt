package jp.co.cyberagent.katalog.dsl

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.moriatsushi.katalog.dsl.binding as actualBinding

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "BindingFactoryDefinition<T>",
        "com.moriatsushi.katalog.dsl.BindingFactoryDefinition",
    ),
)
public typealias BindingFactoryDefinition<T> =
com.moriatsushi.katalog.dsl.BindingFactoryDefinition<T>

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "BindingFactoryDefinition<T>",
        "com.moriatsushi.katalog.dsl.BindingFactoryDefinition",
    ),
)
public typealias BindingUpdateDefinition<T> =
com.moriatsushi.katalog.dsl.BindingUpdateDefinition<T>

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "binding(factory, name, layoutParams, update)",
        "com.moriatsushi.katalog.dsl.binding",
    ),
)
public inline fun <reified T : ViewBinding> GroupScope.binding(
    noinline factory: BindingFactoryDefinition<T>,
    name: String? = null,
    layoutParams: ViewGroup.LayoutParams = WRAP_WIDTH_WRAP_HEIGHT,
    noinline update: BindingUpdateDefinition<T> = {},
) {
    actualBinding(
        factory = factory,
        name = name,
        layoutParams = layoutParams,
        update = update,
    )
}
