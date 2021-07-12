package jp.co.cyberagent.katalog.compose.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Construction
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jp.co.cyberagent.katalog.compose.res.defaultPadding

@Composable
internal fun Empty() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = defaultPadding, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.Construction,
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .size(36.dp),
            tint = MaterialTheme.colors.onBackground.copy(alpha = 0.6F),
        )
        Text(
            text = "No Component Yet",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.4F),
            fontSize = 16.sp
        )
    }

}
