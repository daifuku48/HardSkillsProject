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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.ProjectScreens
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import com.natifedanilharitonov.hardskillsproject.presentation.activities.components.bottombar.BottomNavigationBar
import com.natifedanilharitonov.hardskillsproject.presentation.activities.components.drawerLayout.NavigationDrawer
import com.natifedanilharitonov.hardskillsproject.presentation.activities.components.drawerLayout.NavigationDrawerItems
import com.natifedanilharitonov.hardskillsproject.presentation.activities.components.drawerLayout.TopBar
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val navigator: Navigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
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
                val state by viewModel.uiState.collectAsState()
                val navBackStackEntry by navController.currentBackStackEntryAsState()

                ModalNavigationDrawer(
                    drawerContent = {
                        NavigationDrawer(
                            drawerState = state.drawerState,
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
                            currentRoute = navController.currentDestination?.route,
                        )
                    },
                    drawerState = drawerState,
                    gesturesEnabled = drawerState.isOpen,
                ) {
                    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                        TopBar(drawerState = state.drawerState, onNavigationDrawerClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        })
                    }, bottomBar = {
                        BottomNavigationBar(
                            bottomState = state.bottomState,
                            navigate = { item, index ->
                                viewModel.navigateBottomBarMenu(item, index)
                            },
                            backStackEntry = navBackStackEntry,
                        )
                    }) { paddingValues ->
                        state.startDestination?.let { destination ->
                            NavHost(
                                modifier = Modifier.padding(paddingValues = paddingValues),
                                navController = navController,
                                startDestination = destination,
                            ) {
                                ProjectScreens
                                    .ProjectScreensImpl(
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
                                            Screen.InfoFirstScreen,
                                            Screen.InfoSecondScreen,
                                            Screen.RandomAnimeImageScreen,
                                            Screen.RandomAnimeImageFirstScreen,
                                            Screen.RandomAnimeImageSecondScreen,
                                            Screen.StatisticsScreen,
                                            Screen.StatisticsFirstScreen,
                                            Screen.StatisticsSecondScreen,
                                            Screen.RandomUserFirstScreen,
                                            Screen.RandomUserSecondScreen,
                                            Screen.UsersScreen,
                                        ),
                                    ).show(navGraphBuilder = this, showBottomState = { bottomState ->
                                        viewModel.changeBottomState(bottomState)
                                    }, showDrawerState = { drawerState ->
                                        viewModel.changeDrawerState(drawerState)
                                    })
                            }
                        }
                    }
                }
            }
        }
    }
}
