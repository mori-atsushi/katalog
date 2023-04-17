package com.moriatsushi.katalog.util

import java.util.UUID

internal object UUIDWrapper {
    fun getString(): String {
        return UUID.randomUUID().toString()
    }
}
