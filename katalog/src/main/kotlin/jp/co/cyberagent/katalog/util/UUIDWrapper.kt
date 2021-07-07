package jp.co.cyberagent.katalog.util

import java.util.UUID

internal object UUIDWrapper {
    fun getString(): String {
        return UUID.randomUUID().toString()
    }
}
