package jp.co.cyberagent.katalog.ext.pagesaver.internal

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import jp.co.cyberagent.katalog.ext.pagesaver.BackStackMapper
import jp.co.cyberagent.katalog.ext.pagesaver.BuildConfig

internal class PageStore(
    context: Context
) {
    companion object {
        private const val BACK_STACK_KEY = "back_stack"
    }

    private val sharedPreference =
        context.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, Context.MODE_PRIVATE)

    fun update(backStack: List<String>) {
        val string = BackStackMapper.toString(backStack)
        sharedPreference.edit()
            .putString(BACK_STACK_KEY, string)
            .apply()
    }

    fun read(): List<String>? {
        val backStack = try {
            val string = sharedPreference.getString(BACK_STACK_KEY, null)
            if (string != null) {
                BackStackMapper.fromString(string)
            } else {
                null
            }
        } catch (e: Throwable) {
            return null
        }
        return backStack
    }
}

@Composable
internal fun rememberPageStore(): PageStore {
    val context = LocalContext.current
    return remember(context) {
        PageStore(context)
    }
}

