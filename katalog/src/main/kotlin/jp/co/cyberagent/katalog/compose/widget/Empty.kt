package jp.co.cyberagent.katalog.compose.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jp.co.cyberagent.katalog.compose.res.defaultPadding

@Composable
internal fun Empty() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = defaultPadding, vertical = 24.dp),
        text = "🚧 Empty 🚧",
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.onSecondary,
        fontSize = 24.sp
    )
}
