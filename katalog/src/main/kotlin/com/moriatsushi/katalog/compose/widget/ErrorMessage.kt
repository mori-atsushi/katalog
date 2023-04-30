package com.moriatsushi.katalog.compose.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moriatsushi.katalog.compose.res.defaultPadding
import com.moriatsushi.katalog.compose.util.Urls
import com.moriatsushi.katalog.compose.util.openBrowser

@Composable
internal fun ErrorMessage(text: String) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = defaultPadding, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            imageVector = Icons.Filled.Error,
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .size(36.dp),
            tint = MaterialTheme.colors.onBackground.copy(alpha = 0.6F),
        )
        Text(
            text = text,
            modifier = Modifier
                .padding(bottom = 32.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.4F),
            fontSize = 16.sp,
        )
        Button(onClick = {
            openBrowser(context, Urls.documents)
        }) {
            Text(text = "Documents")
        }
    }
}
