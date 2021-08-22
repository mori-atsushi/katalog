package jp.co.cyberagent.katalog.compose.util

import android.content.Context
import android.content.Intent
import android.net.Uri

internal fun openBrowser(context: Context, url: String) {
    val uri = Uri.parse(url)
    val intent = Intent(Intent.ACTION_VIEW, uri)
    context.startActivity(intent)
}
