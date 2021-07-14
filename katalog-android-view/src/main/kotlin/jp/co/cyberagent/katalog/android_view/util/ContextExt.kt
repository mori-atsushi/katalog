package jp.co.cyberagent.katalog.android_view.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

internal inline fun <reified T : Activity> Context.findActivity(): T? {
    var context = this
    while (context is ContextWrapper) {
        if (context is T) return context
        context = context.baseContext
    }
    return null
}

internal fun Context.findFragmentManager(): FragmentManager? {
    return findActivity<FragmentActivity>()?.supportFragmentManager
}

