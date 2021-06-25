package jp.co.cyberagent.katalog.compose.res

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
internal fun materialColors(
    darkTheme: Boolean
): Colors {
    return if (darkTheme) darkColor else lightColor
}

private val lightUpperColorBg = Color(0xFFeeeeee)
private val lightUpperColorTxt = Color(0xFF000000)
private val darkUpperColorBg = Color(0xFF333333)
private val darkUpperColorTxt = Color(0xFFFFFFFF)
private val lightIconColor = Color(0xFF444444)
private val darkIconColor = Color(0xFFBBBBBB)

private val lightColor = lightColors(
    primary = lightUpperColorBg,
    onPrimary = lightUpperColorTxt,
    surface = lightUpperColorBg,
    onSurface = lightUpperColorTxt,
    onSecondary = lightIconColor
)
private val darkColor = darkColors(
    primary = darkUpperColorBg,
    onPrimary = darkUpperColorTxt,
    surface = darkUpperColorBg,
    onSurface = darkUpperColorTxt,
    onSecondary = darkIconColor
)
