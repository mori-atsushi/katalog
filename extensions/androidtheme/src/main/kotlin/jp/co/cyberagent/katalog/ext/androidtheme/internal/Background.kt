package jp.co.cyberagent.katalog.ext.androidtheme.internal

import android.util.TypedValue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@Composable
internal fun Background(content: @Composable () -> Unit) {
    val context = LocalContext.current
    val color = remember(context) {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(android.R.attr.colorBackground, typedValue, true)
        when {
            typedValue.data != 0 -> typedValue.data
            typedValue.resourceId != 0 -> ContextCompat.getColor(context, typedValue.resourceId)
            else -> 0
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(color))
    ) {
        content()
    }
}
