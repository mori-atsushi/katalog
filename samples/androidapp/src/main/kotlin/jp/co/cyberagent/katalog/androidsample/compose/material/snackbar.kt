package jp.co.cyberagent.katalog.androidsample.compose.material

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SampleSnackbar() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            var clickCount by remember { mutableStateOf(0) }
            ExtendedFloatingActionButton(
                text = { Text("Show snackbar") },
                onClick = {
                    // show snackbar as a suspend function
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Snackbar # ${++clickCount}")
                    }
                }
            )
        },
        content = { innerPadding ->
            Text(
                text = "Body content",
                modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
            )
        }
    )
}

@Composable
fun SampleSnackbarWithSnackbarHost() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = {
            // reuse default SnackbarHost to have default animation and timing handling
            SnackbarHost(it) { data ->
                // custom snackbar with the custom border
                Snackbar(
                    modifier = Modifier.border(2.dp, MaterialTheme.colors.secondary),
                    snackbarData = data
                )
            }
        },
        floatingActionButton = {
            var clickCount by remember { mutableStateOf(0) }
            ExtendedFloatingActionButton(
                text = { Text("Show snackbar") },
                onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Snackbar # ${++clickCount}")
                    }
                }
            )
        },
        content = { innerPadding ->
            Text(
                text = "Custom Snackbar Demo",
                modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
            )
        }
    )
}
