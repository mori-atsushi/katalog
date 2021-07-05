package jp.co.cyberagent.katalog.domain

import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.ext.ExtRootWrapperScope

internal class ExtRootWrapperScopeImpl(
    override val content: @Composable () -> Unit
) : ExtRootWrapperScope
