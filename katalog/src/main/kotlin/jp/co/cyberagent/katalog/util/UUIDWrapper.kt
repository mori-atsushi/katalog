package jp.co.cyberagent.katalog.util

import java.util.UUID

object UUIDWrapper {
    fun getString(): String {
        return UUID.randomUUID().toString()
    }
}
