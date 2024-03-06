package com.natifedanilharitonov.hardskillsproject.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screens
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val navigator: Navigator by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HardSkillsProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    InitNavigation(navController = navController)

                    NavHost(
                        navController = navController,
                        startDestination = Screen.LoginScreen.route
                    ) {
                        Screens(
                            listOf(
                                Screen.LoginScreen,
                                Screen.RegistrationScreen,
                                Screen.MainScreen,
                                Screen.SettingsScreen,
                                Screen.InfoScreen
                            )
                        ).show(navGraphBuilder = this)
                    }
                }
            }
        }
    }

    @Composable
    private fun InitNavigation(navController: NavController){
        navigator.attach(navController)

        DisposableEffect(Unit) {
            onDispose {
                navigator.detach()
            }
        }
    }
}