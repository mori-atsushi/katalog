package jp.co.cyberagent.katalog.android_view.mapper

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LifecycleOwner
import jp.co.cyberagent.katalog.android_view.util.findActivity
import jp.co.cyberagent.katalog.android_view.util.rememberLifecycleOwner
import jp.co.cyberagent.katalog.dsl.ViewDefinitionScope

@Composable
internal fun rememberViewDefinitionScope(): ViewDefinitionScope {
    val context = LocalContext.current
    val lifecycleOwner = rememberLifecycleOwner()
    return remember(context, lifecycleOwner) {
        val activity = context.findActivity<Activity>() ?: error("not found activity")
        ViewDefinitionScopeImpl(
            context = context,
            activity = activity,
            lifecycleOwner = lifecycleOwner
        )
    }
}

private class ViewDefinitionScopeImpl(
    override val context: Context,
    override val activity: Activity,
    override val lifecycleOwner: LifecycleOwner
) : ViewDefinitionScope
