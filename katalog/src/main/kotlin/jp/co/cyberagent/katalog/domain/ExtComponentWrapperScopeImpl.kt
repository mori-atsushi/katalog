package jp.co.cyberagent.katalog.domain

import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.ext.ExtComponentWrapperScope

internal class ExtComponentWrapperScopeImpl(
    override val content: @Composable () -> Unit
) : ExtComponentWrapperScope
