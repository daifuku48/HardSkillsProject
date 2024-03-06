package com.natifedanilharitonov.hardskillsproject.presentation.base.screens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginView
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoView
import com.natifedanilharitonov.hardskillsproject.presentation.main.MainView
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationView
import com.natifedanilharitonov.hardskillsproject.presentation.settings.SettingsView


interface Screen {
    val route: String

    fun show(navGraphBuilder: NavGraphBuilder)

    object LoginScreen : Screen {
        override val route: String = LOGIN_ROUTE

        override fun show(navGraphBuilder: NavGraphBuilder) {
            with(navGraphBuilder) {
                composable(route = LOGIN_ROUTE) { LoginView() }
            }
        }
    }

    object RegistrationScreen : Screen {
        override val route: String
            get() = REGISTRATION_ROUTE

        override fun show(navGraphBuilder: NavGraphBuilder) {
            with(navGraphBuilder) {
                composable(route = REGISTRATION_ROUTE) { RegistrationView() }
            }
        }
    }

    object MainScreen : Screen {
        override val route: String
            get() = MAIN_ROUTE

        override fun show(navGraphBuilder: NavGraphBuilder) {
            with(navGraphBuilder) {
                composable(route = MAIN_ROUTE) { MainView() }
            }
        }
    }

    object SettingsScreen : Screen {
        override val route: String
            get() = SETTINGS_ROUTE

        override fun show(navGraphBuilder: NavGraphBuilder) {
            with(navGraphBuilder) {
                composable(route = SETTINGS_ROUTE) { SettingsView() }
            }
        }
    }

    object InfoScreen : Screen {
        override val route: String
            get() = INFO_ROUTE

        override fun show(navGraphBuilder: NavGraphBuilder) {
            with(navGraphBuilder) {
                composable(route = INFO_ROUTE) { InfoView() }
            }
        }
    }

    companion object {
        private const val LOGIN_ROUTE = "LOGIN_ROUTE"
        private const val REGISTRATION_ROUTE = "REGISTRATION_ROUTE"
        private const val MAIN_ROUTE = "MAIN_ROUTE"
        private const val SETTINGS_ROUTE = "SETTINGS_ROUTE"
        private const val INFO_ROUTE = "INFO_ROUTE"
    }
}