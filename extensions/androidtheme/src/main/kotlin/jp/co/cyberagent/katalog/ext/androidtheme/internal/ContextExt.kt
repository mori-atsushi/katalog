package jp.co.cyberagent.katalog.ext.androidtheme.internal

import android.content.Context
import android.util.TypedValue
import androidx.core.content.ContextCompat

internal fun Context.getAttributeColor(resId: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(resId, typedValue, true)
    return when {
        typedValue.data != 0 -> typedValue.data
        typedValue.resourceId != 0 -> ContextCompat.getColor(this, typedValue.resourceId)
        else -> 0
    }
}
