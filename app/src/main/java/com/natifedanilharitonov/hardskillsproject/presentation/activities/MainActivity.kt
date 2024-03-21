package com.natifedanilharitonov.hardskillsproject.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.natifedanilharitonov.hardskillsproject.presentation.activities.components.bottombar.BottomNavigationBar
import com.natifedanilharitonov.hardskillsproject.presentation.activities.components.drawer_layout.NavigationDrawer
import com.natifedanilharitonov.hardskillsproject.presentation.activities.components.drawer_layout.NavigationDrawerItems
import com.natifedanilharitonov.hardskillsproject.presentation.activities.components.drawer_layout.TopBar
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screens
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val navigator: Navigator by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HardSkillsProjectTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val context = LocalContext.current
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()
                navigator.attach(navController)

                DisposableEffect(Unit) {
                    onDispose {
                        navigator.detach()
                    }
                }

                val viewModel: MainActivityViewModelImpl by remember {
                    inject()
                }
                val state by viewModel.state.collectAsState()

                ModalNavigationDrawer(
                    drawerContent = {
                        NavigationDrawer(
                            menuItems = remember { NavigationDrawerItems(context).items },
                            navigate = { route ->
                                viewModel.navigateDrawerMenu(route)
                                scope.launch {
                                    drawerState.close()
                                }
                            },
                            closeDrawer = {
                                scope.launch { drawerState.close() }
                            },
                            currentRoute = navController.currentDestination?.route
                        )
                    },
                    drawerState = drawerState,
                    gesturesEnabled = drawerState.isOpen
                ) {
                    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                        TopBar(onNavigationDrawerClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        })
                    }, bottomBar = {
                        BottomNavigationBar(bottomState = state.bottomState,
                            navigationSelectedItem = state.bottomNavigationSelectedItem,
                            navigate = { item, index ->
                                viewModel.navigateBottomBarMenu(item, index)
                            })
                    }) { paddingValues ->
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
                                        Screen.MainFirstMockScreen,
                                        Screen.MainSecondMockScreen,
                                        Screen.SettingsScreen,
                                        Screen.SettingFirstScreen,
                                        Screen.SettingsSecondScreen,
                                        Screen.InfoScreen,
                                        Screen.RandomAnimeImage,
                                        Screen.StatisticsScreen,
                                        Screen.UsersScreen,
                                    )
                                ).show(navGraphBuilder = this, showBottomState = { bottomState ->
                                    viewModel.changeBottomState(bottomState)
                                })
                            }
                        }
                    }
                }
            }
        }
    }
}