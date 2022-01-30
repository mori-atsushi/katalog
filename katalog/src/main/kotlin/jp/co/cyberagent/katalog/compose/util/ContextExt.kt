package jp.co.cyberagent.katalog.compose.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

internal inline fun <reified T : Activity> Context.findActivity(): T? {
    var context = this
    while (context is ContextWrapper) {
        if (context is T) return context
        context = context.baseContext
    }
    return null
}
