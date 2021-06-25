package jp.co.cyberagent.katalog.compose.mapper

import android.view.ContextThemeWrapper
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import jp.co.cyberagent.katalog.domain.ParamsFactory
import jp.co.cyberagent.katalog.dsl.ViewDefinition

@Composable
internal fun <T : View> ViewToCompose(
    paramsFactory: ParamsFactory,
    layoutParams: ViewGroup.LayoutParams? = null,
    definition: ViewDefinition<T>
) {
    AndroidView(
        factory = {
            val params = paramsFactory.getCatalogParams()
            val context = if (params.themeResId != null) {
                ContextThemeWrapper(it, params.themeResId)
            } else {
                it
            }
            val view = definition.invoke(context)
            if (layoutParams != null) {
                view.layoutParams = layoutParams
            }
            view
        }
    )
}
