package jp.co.cyberagent.katalog.android_view.mapper

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
import jp.co.cyberagent.katalog.android_view.util.findFragmentManager
import jp.co.cyberagent.katalog.dsl.FragmentDefinition
import jp.co.cyberagent.katalog.dsl.FragmentOnCreateListener
import java.util.UUID

@Composable
internal fun <T : Fragment> FragmentToCompose(
    layoutParams: ViewGroup.LayoutParams? = null,
    onCreateView: FragmentOnCreateListener<T>,
    definition: FragmentDefinition<T>
) {
    val view by fragmentViewState(
        definition = definition,
        onCreateView = onCreateView
    )
    view?.let {
        FragmentContainerView(
            layoutParams = layoutParams,
            view = it
        )
    }
}

@Composable
private fun <T : Fragment> fragmentViewState(
    definition: FragmentDefinition<T>,
    onCreateView: FragmentOnCreateListener<T>
): State<View?> {
    val context = LocalContext.current
    val fragmentManager = remember(context) {
        context.findFragmentManager() ?: error("not found FragmentManager")
    }
    val view = remember { mutableStateOf<View?>(null) }
    val scope = rememberViewDefinitionScope()
    DisposableEffect(definition) {
        val tag = UUID.randomUUID().toString()
        val fragment = definition.invoke(scope)
        fragmentManager.commitNow(true) {
            add(fragment, tag)
        }
        view.value = fragment.view
        onCreateView.invoke(scope, fragment)
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
    view: View
) {
    AndroidView(
        factory = {
            val container = FragmentContainerView(it)
            if (layoutParams != null) {
                container.layoutParams = layoutParams
            }
            container.addView(view)
            container
        }
    )
}
