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

@Composable
fun Preview(
    modifier: Modifier = Modifier,
    scale: Float = 1.0F,
    clickable: Boolean = false,
    definition: @Composable () -> Unit
) {
    BoxWithConstraints(
        modifier = modifier
    ) {
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
            definition()
        }
        // click mask
        if (!clickable) {
            Box(
                modifier = Modifier
                    .pointerInput(Unit) { }
                    .fillMaxSize()
            )
        }
    }
}
