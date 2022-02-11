package jp.co.cyberagent.katalog.ext.androidtheme.internal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
internal fun Background(content: @Composable () -> Unit) {
    val context = LocalContext.current
    val color = remember(context) {
        context.getAttributeColor(android.R.attr.colorBackground)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(color))
    ) {
        content()
    }
}
