package jp.co.cyberagent.katalog.compose.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import jp.co.cyberagent.katalog.compose.util.LocalKatalog
import jp.co.cyberagent.katalog.ext.KatalogExt

@Composable
fun Preview(
    modifier: Modifier = Modifier,
    scale: Float = 1.0F,
    clickable: Boolean = false,
    definition: @Composable () -> Unit
) {
    val katalog = LocalKatalog.current
    Box(modifier = modifier) {
        ExtensionsWrapper(katalog.extensions) {
            Scaler(scale) {
                definition()
                ClickMask(!clickable)
            }
        }
    }
}

@Composable
private fun ExtensionsWrapper(
    extensions: List<KatalogExt>,
    content: @Composable () -> Unit
) {
    if (extensions.isEmpty()) {
        content()
        return
    }
    ExtensionsWrapper(extensions.dropLast(1)) {
        extensions.last().previewWrapper {
            content()
        }
    }
}

@Composable
private fun Scaler(
    scale: Float = 1.0F,
    content: @Composable () -> Unit
) {
    BoxWithConstraints {
        val size = 1.0F / scale
        val width = (this.maxWidth.value * size).dp
        val height = (this.maxHeight.value * size).dp
        Box(
            modifier = Modifier
                .requiredWidth(width)
                .requiredHeight(height)
                .scale(scale),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Composable
private fun ClickMask(enabled: Boolean = false) {
    if (!enabled) return
    Box(
        modifier = Modifier
            .pointerInput(Unit) { }
            .fillMaxSize()
    )
}
