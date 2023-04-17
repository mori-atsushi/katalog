package com.moriatsushi.katalog.compose.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun KatalogTopAppBar(
    title: String,
    isVisibleDivider: Boolean = true,
    navigationIcon: @Composable (() -> Unit)? = null,
) {
    Box {
        Dissolve(
            targetState = (title to navigationIcon)
        ) { (title, navigationIcon) ->
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onBackground,
                navigationIcon = navigationIcon
            )
        }
        AnimatedVisibility(
            visible = isVisibleDivider,
            modifier = Modifier.align(Alignment.BottomCenter),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Divider(
                color = MaterialTheme.colors.surface
            )
        }
    }
}
