package com.moriatsushi.katalog.ext.pagesaver.internal

internal class DummyLocalStorage(
    private val map: MutableMap<String, Any?> = mutableMapOf(),
) : LocalStorage {
    override fun putString(key: String, value: String?) {
        map[key] = value
    }

    override fun getString(key: String): String? {
        return map[key] as? String
    }
}
