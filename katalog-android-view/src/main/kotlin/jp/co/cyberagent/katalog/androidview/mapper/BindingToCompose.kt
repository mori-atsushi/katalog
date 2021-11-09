package jp.co.cyberagent.katalog.androidview.mapper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import jp.co.cyberagent.katalog.dsl.BindingFactoryDefinition
import jp.co.cyberagent.katalog.dsl.BindingUpdateDefinition

@Composable
internal fun <T : ViewBinding> BindingToCompose(
    factory: BindingFactoryDefinition<T>,
    layoutParams: ViewGroup.LayoutParams? = null,
    update: BindingUpdateDefinition<T> = {}
) {
    ViewToCompose(layoutParams) {
        val inflater = LayoutInflater.from(context)
        val binding = factory.invoke(inflater, null, false)
        update.invoke(this, binding)
        if (binding is ViewDataBinding) {
            binding.executePendingBindings()
        }
        binding.root
    }
}
