package com.natifedanilharitonov.hardskillsproject.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.natifedanilharitonov.hardskillsproject.presentation.activities.bottombar.BottomNavigationBar
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screens
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val navigator: Navigator by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HardSkillsProjectTheme {
                val navController = rememberNavController()
                InitNavigation(navController = navController)

                val viewModel: MainActivityViewModel by remember {
                    inject()
                }
                val state by viewModel.state.collectAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (state.bottomState) {
                            BottomNavigationBar(
                                navigationSelectedItem = state.bottomNavigationSelectedItem,
                                navigate = { item, index ->
                                    viewModel.navigateBottomBarMenu(item, index)
                                }
                            )
                        }
                    }
                ) { paddingValues ->
                    state.startDestination?.let { destination ->
                        NavHost(
                            modifier = Modifier.padding(paddingValues = paddingValues),
                            navController = navController,
                            startDestination = destination
                        ) {
                            Screens(
                                listOf(
                                    Screen.LoginScreen,
                                    Screen.RegistrationScreen,
                                    Screen.MainScreen,
                                    Screen.SettingsScreen,
                                    Screen.InfoScreen
                                )
                            ).show(
                                navGraphBuilder = this,
                                changeBottomState = { bottomState ->
                                    viewModel.changeBottomState(bottomState)
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun InitNavigation(navController: NavController) {
        navigator.attach(navController)

        DisposableEffect(Unit) {
            onDispose {
                navigator.detach()
            }
        }
    }
}