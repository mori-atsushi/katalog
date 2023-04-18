package com.moriatsushi.katalog.ext

import androidx.compose.runtime.Stable
import com.moriatsushi.katalog.domain.ExtensionBuilderImpl

@Stable
public interface KatalogExt {
    public companion object {
        @ExperimentalKatalogExtApi
        @Suppress("FunctionName")
        public fun Builder(name: String): ExtensionBuilder =
            ExtensionBuilderImpl(name)
    }

    @ExperimentalKatalogExtApi
    public val name: String

    @ExperimentalKatalogExtApi
    public val componentWrapper: ExtComponentWrapper?
        get() = null

    @ExperimentalKatalogExtApi
    public val rootWrapper: ExtRootWrapper?
        get() = null
}
