package jp.co.cyberagent.katalog.compose.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import jp.co.cyberagent.katalog.compose.util.LocalKatalog
import jp.co.cyberagent.katalog.ext.ExtComponentWrapper

@Composable
fun Preview(
    modifier: Modifier = Modifier,
    scale: Float = 1.0F,
    clickable: Boolean = false,
    definition: @Composable () -> Unit
) {
    val katalog = LocalKatalog.current
    val componentWrappers = katalog.extensions.componentWrappers
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.background
    ) {
        ExtensionsWrappers(componentWrappers) {
            Scaler(scale) {
                definition()
                ClickMask(!clickable)
            }
        }
    }
}

@Composable
private fun ExtensionsWrappers(
    componentWrappers: List<ExtComponentWrapper>,
    content: @Composable () -> Unit
) {
    if (componentWrappers.isEmpty()) {
        content()
        return
    }
    ExtensionsWrappers(componentWrappers.dropLast(1)) {
        componentWrappers.last().invoke {
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
