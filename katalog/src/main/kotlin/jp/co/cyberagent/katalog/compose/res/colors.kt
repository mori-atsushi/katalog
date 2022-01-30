package jp.co.cyberagent.katalog.compose.res

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
internal fun materialColors(
    isDarkTheme: Boolean
): Colors {
    return if (isDarkTheme) darkColor else lightColor
}

private val lightColorBg = Color.White
private val lightColorTxt = Color(0xFF000000)
private val lightUpperColorBg = Color(0xFFeeeeee)
private val darkColorBg = Color(0xFF121212)
private val darkColorTxt = Color.White
private val darkUpperColorBg = Color(0xFF333333)

private val lightColor = lightColors(
    surface = lightUpperColorBg,
    onSurface = lightColorTxt,
    background = lightColorBg,
    onBackground = lightColorTxt
)
private val darkColor = darkColors(
    surface = darkUpperColorBg,
    onSurface = darkColorTxt,
    background = darkColorBg,
    onBackground = darkColorTxt
)
