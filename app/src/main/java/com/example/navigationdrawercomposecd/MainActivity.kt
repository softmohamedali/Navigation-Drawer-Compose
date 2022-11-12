package com.example.navigationdrawercomposecd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationdrawercomposecd.ui.theme.NavigationDrawerComposeCDTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerComposeCDTheme {
                val scaffouldKey = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffouldKey,
                    topBar = {
                        AppBar {
                            scope.launch{ scaffouldKey.drawerState.open() }
                        }
                    },
                    drawerContent = {
                        NavigationDrawerHeader()
                        NavigationDrawerBody(
                            drawerItems = listOf(
                                MenuItem(
                                    "home",
                                    "home",
                                    Icons.Default.Add
                                ),
                                MenuItem(
                                    "home",
                                    "home",
                                    Icons.Default.Add
                                ),
                                MenuItem(
                                    "home",
                                    "home",
                                    Icons.Default.Add
                                ),
                                MenuItem(
                                    "home",
                                    "home",
                                    Icons.Default.Add
                                ),
                            ),
                            onItemClick = {
                                scope.launch {
                                    scaffouldKey.snackbarHostState.showSnackbar(
                                        it.title,
                                        "ok",
                                        SnackbarDuration.Short
                                    )
                                }
                            }
                        )
                    }
                ){}
            }
        }
    }
}
