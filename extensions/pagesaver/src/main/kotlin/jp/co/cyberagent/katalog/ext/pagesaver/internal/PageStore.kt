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

    fun update(backStack: List<String>) {
        val string = BackStackMapper.toString(backStack)
        localStorage.putString(BACK_STACK_KEY, string)
    }

    fun read(): List<String>? {
        val backStack = try {
            val string = localStorage.getString(BACK_STACK_KEY)
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
internal fun rememberPageStore(
    localStorage: LocalStorage = rememberLocalStorage()
): PageStore {
    return remember(localStorage) {
        PageStore(localStorage)
    }
}

