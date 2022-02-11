package jp.co.cyberagent.katalog.ext.pagesaver.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import jp.co.cyberagent.katalog.ext.pagesaver.BackStackMapper

internal class PageStore(
    private val localStorage: LocalStorage
) {
    companion object {
        private const val BACK_STACK_KEY = "back_stack"
    }

    fun update(title: String, backStack: List<String>) {
        val string = BackStackMapper.toString(backStack)
        val key = createKey(title)
        localStorage.putString(key, string)
    }

    fun read(title: String): List<String>? {
        val backStack = try {
            val key = createKey(title)
            val string = localStorage.getString(key)
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

    private fun createKey(title: String): String {
        return "$BACK_STACK_KEY:$title"
    }
}

@Composable
internal fun rememberPageStore(
    localStorage: LocalStorage = rememberLocalStorage()
): PageStore {
    return remember(localStorage) {
        PageStore(localStorage)
    }
}
