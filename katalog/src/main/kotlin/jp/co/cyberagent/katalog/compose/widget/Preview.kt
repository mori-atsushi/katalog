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
import jp.co.cyberagent.katalog.domain.Extensions
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtComponentWrapper

@OptIn(ExperimentalKatalogExtApi::class)
@Composable
internal fun Preview(
    extensions: Extensions,
    modifier: Modifier = Modifier,
    scale: Float = 1.0F,
    clickable: Boolean = false,
    definition: @Composable () -> Unit
) {
    val componentWrappers = extensions.componentWrappers
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.background
    ) {
        ExtensionsWrappers(
            componentWrappers = componentWrappers,
            extensions = extensions
        ) {
            Scaler(scale) {
                definition()
                ClickMask(!clickable)
            }
        }
    }
}

@ExperimentalKatalogExtApi
@Composable
private fun ExtensionsWrappers(
    componentWrappers: List<ExtComponentWrapper>,
    extensions: Extensions,
    content: @Composable () -> Unit
) {
    if (componentWrappers.isEmpty()) {
        content()
        return
    }
    ExtensionsWrappers(
        componentWrappers = componentWrappers.dropLast(1),
        extensions = extensions
    ) {
        val target = componentWrappers.last()
        extensions.wrapperScope.target {
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
