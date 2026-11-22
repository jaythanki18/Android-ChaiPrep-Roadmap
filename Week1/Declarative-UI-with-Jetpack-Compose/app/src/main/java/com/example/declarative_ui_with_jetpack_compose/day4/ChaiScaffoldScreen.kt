package com.example.declarative_ui_with_jetpack_compose.day4

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.declarative_ui_with_jetpack_compose.day3.ContactListScreen
import com.example.declarative_ui_with_jetpack_compose.ui.theme.DeclarativeUIwithJetpackComposeTheme
import kotlinx.coroutines.launch

// Scaffold wires the standard Material 3 slots: top bar, snackbar host, FAB and content.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChaiScaffoldScreen(modifier: Modifier = Modifier) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var orders by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("ChaiPrep Contacts", style = MaterialTheme.typography.titleLarge) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                ),
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    orders++
                    scope.launch { snackbarHostState.showSnackbar("Chai ordered! (#$orders)") }
                },
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Order chai")
            }
        },
    ) { innerPadding ->
        ContactListScreen(modifier = Modifier.padding(innerPadding))
    }
}

@Preview(showBackground = true)
@Composable
private fun ChaiScaffoldScreenPreview() {
    DeclarativeUIwithJetpackComposeTheme { ChaiScaffoldScreen() }
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ChaiScaffoldScreenDarkPreview() {
    DeclarativeUIwithJetpackComposeTheme { ChaiScaffoldScreen() }
}
