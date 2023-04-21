package com.moriatsushi.katalog.ext.pagesaver.internal

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

private const val PACKAGE_NAME = "com.moriatsushi.katalog.ext.pagesaver"

internal interface LocalStorage {
    fun putString(key: String, value: String?)
    fun getString(key: String): String?
}

private class LocalStorageImpl(
    context: Context
) : LocalStorage {
    private val sharedPreference =
        context.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE)

    override fun putString(key: String, value: String?) {
        sharedPreference.edit()
            .putString(key, value)
            .apply()
    }

    override fun getString(key: String): String? {
        return sharedPreference.getString(key, null)
    }
}

@Composable
internal fun rememberLocalStorage(
    context: Context = LocalContext.current
): LocalStorage {
    return remember(context) {
        LocalStorageImpl(context)
    }
}
