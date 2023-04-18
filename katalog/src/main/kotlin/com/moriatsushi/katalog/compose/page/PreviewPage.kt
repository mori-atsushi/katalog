package com.moriatsushi.katalog.compose.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moriatsushi.katalog.compose.widget.KatalogTopAppBar
import com.moriatsushi.katalog.compose.widget.Preview
import com.moriatsushi.katalog.domain.CatalogItem
import com.moriatsushi.katalog.domain.Extensions
import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.ExtNavState

@ExperimentalKatalogExtApi
@Composable
internal fun PreviewPage(
    component: CatalogItem.Component,
    extensions: Extensions,
    extNavState: ExtNavState,
    onClickClose: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        PreviewTopAppBar(
            name = component.name,
            onClickClose = onClickClose
        )
        Preview(
            extensions = extensions,
            extNavState = extNavState,
            modifier = Modifier.fillMaxSize(),
            clickable = true,
            definition = component.definition
        )
    }
}

@Composable
private fun PreviewTopAppBar(
    name: String,
    onClickClose: () -> Unit
) {
    KatalogTopAppBar(
        title = name,
        navigationIcon = {
            IconButton(onClick = onClickClose) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "close"
                )
            }
        }
    )
}
