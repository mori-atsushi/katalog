package jp.co.cyberagent.katalog.compose.mapper

import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commitNow
import jp.co.cyberagent.katalog.compose.util.LocalFragmentManager
import jp.co.cyberagent.katalog.domain.ParamsFactory
import jp.co.cyberagent.katalog.dsl.FragmentDefinition
import jp.co.cyberagent.katalog.dsl.FragmentOnCreateListener
import jp.co.cyberagent.katalog.util.UUIDWrapper

@Composable
internal fun <T : Fragment> FragmentToCompose(
    paramsFactory: ParamsFactory,
    layoutParams: ViewGroup.LayoutParams? = null,
    onCreateView: FragmentOnCreateListener<T>,
    definition: FragmentDefinition<T>
) {
    val view by fragmentViewState(
        definition = definition,
        onCreateView = onCreateView
    )
    FragmentContainerView(
        layoutParams = layoutParams,
        view = view
    )
}

@Composable
private fun <T : Fragment> fragmentViewState(
    definition: FragmentDefinition<T>,
    onCreateView: FragmentOnCreateListener<T>
): State<View?> {
    val fragmentManager = LocalFragmentManager.current
    val context = LocalContext.current
    val view = remember { mutableStateOf<View?>(null) }
    DisposableEffect(definition) {
        val tag = UUIDWrapper.getString()
        val fragment = definition.invoke(context)
        fragmentManager.commitNow(true) {
            add(fragment, tag)
        }
        view.value = fragment.view
        onCreateView.invoke(fragment)
        onDispose {
            fragmentManager.commitNow(true) {
                remove(fragment)
            }
        }
    }
    return view
}

@Composable
private fun FragmentContainerView(
    layoutParams: ViewGroup.LayoutParams? = null,
    view: View?
) {
    AndroidView(
        factory = {
            val container = FragmentContainerView(it)
            if (layoutParams != null) {
                container.layoutParams = layoutParams
            }
            container
        },
        update = {
            if (view != null) {
                it.removeAllViews()
                it.addView(view)
            }
        }
    )
}
