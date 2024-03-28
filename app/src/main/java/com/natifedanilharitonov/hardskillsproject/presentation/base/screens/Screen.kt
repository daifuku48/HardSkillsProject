package com.natifedanilharitonov.hardskillsproject.presentation.base.screens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.natifedanilharitonov.hardskillsproject.domain.Utils.HIDE_NAV_STATE
import com.natifedanilharitonov.hardskillsproject.domain.Utils.SHOW_NAV_STATE
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoView
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginView
import com.natifedanilharitonov.hardskillsproject.presentation.main.MainView
import com.natifedanilharitonov.hardskillsproject.presentation.main_first.MainFirstView
import com.natifedanilharitonov.hardskillsproject.presentation.main_second.MainSecondMockView
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.RandomAnimeImageView
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationView
import com.natifedanilharitonov.hardskillsproject.presentation.settings.SettingsView
import com.natifedanilharitonov.hardskillsproject.presentation.settings_first.SettingsFirstView
import com.natifedanilharitonov.hardskillsproject.presentation.settings_second.SettingsSecondView
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.StatisticsView
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_first.StatisticsFirstView
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.StatisticsSecondView
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.UserListView


abstract class Screen {
    abstract val route: String
    protected abstract val bottomState: Boolean
    protected abstract val drawerState: Boolean
    abstract fun show(
        navGraphBuilder: NavGraphBuilder,
        showBottomState: (Boolean) -> Unit,
        showDrawerState: (Boolean) -> Unit
    )

    object LoginScreen : Screen() {
        override val route: String = LOGIN_ROUTE
        override val bottomState: Boolean
            get() = HIDE_NAV_STATE
        override val drawerState: Boolean
            get() = HIDE_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = LOGIN_ROUTE) {
                    showBottomState(bottomState)
                    showDrawerState(drawerState)
                    LoginView()
                }
            }
        }
    }

    object RegistrationScreen : Screen() {
        override val route: String
            get() = REGISTRATION_ROUTE
        override val bottomState: Boolean
            get() = HIDE_NAV_STATE
        override val drawerState: Boolean
            get() = HIDE_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = REGISTRATION_ROUTE) {
                    showBottomState(bottomState)
                    showDrawerState(drawerState)
                    RegistrationView()
                }
            }
        }
    }

    object MainScreen : Screen() {
        override val route: String
            get() = MAIN_ROUTE
        override val bottomState: Boolean
            get() = SHOW_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = MAIN_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    MainView()
                }
            }
        }
    }

    object MainFirstMockScreen : Screen() {
        override val route: String
            get() = MAIN_FIRST_MOCK_ROUTE
        override val bottomState: Boolean
            get() = SHOW_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = MAIN_FIRST_MOCK_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    MainFirstView()
                }
            }
        }
    }

    object MainSecondMockScreen : Screen() {
        override val route: String
            get() = MAIN_SECOND_MOCK_ROUTE
        override val bottomState: Boolean
            get() = SHOW_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = MAIN_SECOND_MOCK_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    MainSecondMockView()
                }
            }
        }

    }

    object SettingsScreen : Screen() {
        override val route: String
            get() = SETTINGS_ROUTE
        override val bottomState: Boolean
            get() = SHOW_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = SETTINGS_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    SettingsView()
                }
            }
        }
    }

    object SettingFirstScreen : Screen() {
        override val route: String
            get() = SETTINGS_FIRST_ROUTE
        override val bottomState: Boolean
            get() = SHOW_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = SETTINGS_FIRST_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    SettingsFirstView()
                }
            }
        }

    }

    object SettingsSecondScreen : Screen() {
        override val route: String
            get() = SETTINGS_SECOND_ROUTE
        override val bottomState: Boolean
            get() = SHOW_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = SETTINGS_SECOND_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    SettingsSecondView()
                }
            }
        }

    }

    object InfoScreen : Screen() {
        override val route: String
            get() = INFO_ROUTE
        override val bottomState: Boolean
            get() = SHOW_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = INFO_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    InfoView()
                }
            }
        }
    }

    object RandomAnimeImage : Screen() {
        override val route: String
            get() = ONBOARDING_ROUTE
        override val bottomState: Boolean
            get() = HIDE_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = ONBOARDING_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    RandomAnimeImageView()
                }
            }
        }
    }

    object StatisticsScreen : Screen() {
        override val route: String
            get() = STATISTICS_ROUTE
        override val bottomState: Boolean
            get() = HIDE_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = STATISTICS_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    StatisticsView()
                }
            }
        }
    }

    object UsersScreen : Screen() {
        override val route: String
            get() = USERS_ROUTE
        override val bottomState: Boolean
            get() = HIDE_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = USERS_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    UserListView()
                }
            }
        }
    }

    object StatisticsFirstScreen : Screen() {
        override val route: String
            get() = STATISTICS_FIRST_ROUTE
        override val bottomState: Boolean
            get() = HIDE_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = STATISTICS_FIRST_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    StatisticsFirstView()
                }
            }
        }
    }

    object StatisticsSecondScreen : Screen() {
        override val route: String
            get() = STATISTICS_SECOND_ROUTE
        override val bottomState: Boolean
            get() = HIDE_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit
        ) {
            with(navGraphBuilder) {
                composable(route = STATISTICS_SECOND_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    StatisticsSecondView()
                }
            }
        }
    }

    companion object {
        private const val LOGIN_ROUTE = "LOGIN_ROUTE"
        private const val REGISTRATION_ROUTE = "REGISTRATION_ROUTE"
        private const val MAIN_ROUTE = "MAIN_ROUTE"
        private const val MAIN_FIRST_MOCK_ROUTE = "MAIN_FIRST_MOCK_ROUTE"
        private const val MAIN_SECOND_MOCK_ROUTE = "MAIN_SECOND_MOCK_ROUTE"
        private const val SETTINGS_ROUTE = "SETTINGS_ROUTE"
        private const val SETTINGS_FIRST_ROUTE = "SETTINGS_FIRST_ROUTE"
        private const val SETTINGS_SECOND_ROUTE = "SETTINGS_SECOND_ROUTE"
        private const val INFO_ROUTE = "INFO_ROUTE"
        private const val ONBOARDING_ROUTE = "ONBOARDING_ROUTE"
        private const val STATISTICS_ROUTE = "STATISTICS_ROUTE"
        private const val STATISTICS_FIRST_ROUTE = "STATISTICS_FIRST_ROUTE"
        private const val STATISTICS_SECOND_ROUTE = "STATISTICS_SECOND_ROUTE"
        private const val USERS_ROUTE = "USERS_ROUTE"
    }
}