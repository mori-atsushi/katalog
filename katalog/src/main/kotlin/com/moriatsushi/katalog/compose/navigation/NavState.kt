package com.moriatsushi.katalog.compose.navigation

import androidx.compose.runtime.Immutable
import com.moriatsushi.katalog.util.UUIDWrapper

@Immutable
internal data class NavState<T>(
    val destination: T,
    val index: Int,
    private val uuid: String,
) {
    companion object {
        fun <T> of(
            destination: T,
            index: Int
        ): NavState<T> {
            val uuid = UUIDWrapper.getString()
            return NavState(
                destination,
                index,
                uuid
            )
        }
    }

    val key: String = "$index-$uuid"
}
