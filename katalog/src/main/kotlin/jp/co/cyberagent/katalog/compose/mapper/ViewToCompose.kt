package jp.co.cyberagent.katalog.compose.mapper

import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import jp.co.cyberagent.katalog.dsl.ViewDefinition

@Composable
internal fun <T : View> ViewToCompose(
    layoutParams: ViewGroup.LayoutParams? = null,
    definition: ViewDefinition<T>
) {
    val scope = rememberViewDefinitionScope()
    AndroidView(
        factory = {
            val view = definition.invoke(scope)
            if (layoutParams != null) {
                view.layoutParams = layoutParams
            }
            view
        }
    )
}
