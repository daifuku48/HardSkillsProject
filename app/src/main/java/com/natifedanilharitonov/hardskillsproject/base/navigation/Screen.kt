package com.natifedanilharitonov.hardskillsproject.base.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoView
import com.natifedanilharitonov.hardskillsproject.presentation.infoFirst.InfoFirstView
import com.natifedanilharitonov.hardskillsproject.presentation.infoSecond.InfoSecondView
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginView
import com.natifedanilharitonov.hardskillsproject.presentation.main.MainView
import com.natifedanilharitonov.hardskillsproject.presentation.mainFirst.MainFirstView
import com.natifedanilharitonov.hardskillsproject.presentation.mainSecond.MainSecondMockView
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.RandomAnimeImageView
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageFirst.RandomAnimeImageFirstView
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageSecond.RandomAnimeImageSecondView
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationView
import com.natifedanilharitonov.hardskillsproject.presentation.settings.SettingsView
import com.natifedanilharitonov.hardskillsproject.presentation.settingsFirst.SettingsFirstView
import com.natifedanilharitonov.hardskillsproject.presentation.settingsSecond.SettingsSecondView
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.StatisticsView
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsFirst.StatisticsFirstView
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.StatisticsSecondView
import com.natifedanilharitonov.hardskillsproject.presentation.userList.UserListView
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.UserRandomFirstView
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomSecond.UserRandomSecondView
import com.natifedanilharitonov.hardskillsproject.utils.Constants.HIDE_NAV_STATE
import com.natifedanilharitonov.hardskillsproject.utils.Constants.SHOW_NAV_STATE

abstract class Screen {
    abstract val route: String
    protected abstract val bottomState: Boolean
    protected abstract val drawerState: Boolean

    abstract fun show(
        navGraphBuilder: NavGraphBuilder,
        showBottomState: (Boolean) -> Unit,
        showDrawerState: (Boolean) -> Unit,
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
            showDrawerState: (Boolean) -> Unit,
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
            showDrawerState: (Boolean) -> Unit,
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
            showDrawerState: (Boolean) -> Unit,
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
            showDrawerState: (Boolean) -> Unit,
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
            showDrawerState: (Boolean) -> Unit,
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
            showDrawerState: (Boolean) -> Unit,
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
            showDrawerState: (Boolean) -> Unit,
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
            showDrawerState: (Boolean) -> Unit,
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
            showDrawerState: (Boolean) -> Unit,
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

    object InfoFirstScreen : Screen() {
        override val route: String
            get() = INFO_FIRST_ROUTE
        override val bottomState: Boolean
            get() = SHOW_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit,
        ) {
            with(navGraphBuilder) {
                composable(route = INFO_FIRST_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    InfoFirstView()
                }
            }
        }
    }

    object InfoSecondScreen : Screen() {
        override val route: String
            get() = INFO_SECOND_ROUTE
        override val bottomState: Boolean
            get() = SHOW_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit,
        ) {
            with(navGraphBuilder) {
                composable(route = INFO_SECOND_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    InfoSecondView()
                }
            }
        }
    }

    object RandomAnimeImageScreen : Screen() {
        override val route: String
            get() = RANDOM_ANIME_IMAGE_ROUTE
        override val bottomState: Boolean
            get() = HIDE_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit,
        ) {
            with(navGraphBuilder) {
                composable(route = RANDOM_ANIME_IMAGE_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    RandomAnimeImageView()
                }
            }
        }
    }

    object RandomAnimeImageFirstScreen : Screen() {
        override val route: String
            get() = RANDOM_ANIME_IMAGE_FIRST_ROUTE
        override val bottomState: Boolean
            get() = HIDE_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit,
        ) {
            with(navGraphBuilder) {
                composable(route = RANDOM_ANIME_IMAGE_FIRST_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    RandomAnimeImageFirstView()
                }
            }
        }
    }

    object RandomAnimeImageSecondScreen : Screen() {
        override val route: String
            get() = RANDOM_ANIME_IMAGE_SECOND_ROUTE
        override val bottomState: Boolean
            get() = HIDE_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit,
        ) {
            with(navGraphBuilder) {
                composable(route = RANDOM_ANIME_IMAGE_SECOND_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    RandomAnimeImageSecondView()
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
            showDrawerState: (Boolean) -> Unit,
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
            showDrawerState: (Boolean) -> Unit,
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
            showDrawerState: (Boolean) -> Unit,
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

    object RandomUserFirstScreen : Screen() {
        override val route: String
            get() = RANDOM_USER_FIRST_ROUTE
        override val bottomState: Boolean
            get() = HIDE_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit,
        ) {
            with(navGraphBuilder) {
                composable(route = RANDOM_USER_FIRST_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    UserRandomFirstView()
                }
            }
        }
    }

    object RandomUserSecondScreen : Screen() {
        override val route: String
            get() = RANDOM_USER_SECOND_ROUTE
        override val bottomState: Boolean
            get() = HIDE_NAV_STATE
        override val drawerState: Boolean
            get() = SHOW_NAV_STATE

        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit,
        ) {
            with(navGraphBuilder) {
                composable(route = RANDOM_USER_SECOND_ROUTE) {
                    showDrawerState(drawerState)
                    showBottomState(bottomState)
                    UserRandomSecondView()
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
            showDrawerState: (Boolean) -> Unit,
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
        private const val INFO_FIRST_ROUTE = "INFO_FIRST_ROUTE"
        private const val INFO_SECOND_ROUTE = "INFO_SECOND_ROUTE"
        private const val RANDOM_ANIME_IMAGE_ROUTE = "RANDOM_ANIME_ROUTE"
        private const val RANDOM_ANIME_IMAGE_FIRST_ROUTE = "RANDOM_ANIME_FIRST_ROUTE"
        private const val RANDOM_ANIME_IMAGE_SECOND_ROUTE = "RANDOM_ANIME_IMAGE_SECOND_ROUTE"
        private const val STATISTICS_ROUTE = "STATISTICS_ROUTE"
        private const val STATISTICS_FIRST_ROUTE = "STATISTICS_FIRST_ROUTE"
        private const val STATISTICS_SECOND_ROUTE = "STATISTICS_SECOND_ROUTE"
        private const val RANDOM_USER_FIRST_ROUTE = "RANDOM_USER_FIRST_ROUTE"
        private const val RANDOM_USER_SECOND_ROUTE = "RANDOM_USER_SECOND_ROUTE"
        private const val USERS_ROUTE = "USERS_ROUTE"
    }
}
