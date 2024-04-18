package com.natifedanilharitonov.hardskillsproject.animeAnimeRandom.common

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import com.atiurin.ultron.core.compose.createUltronComposeRule
import com.atiurin.ultron.core.compose.list.composeList
import com.atiurin.ultron.extensions.assertDoesNotExist
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.assertTextContains
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.inputText
import com.atiurin.ultron.page.Screen
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivity
import com.natifedanilharitonov.hardskillsproject.utils.TestTags
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.CHART_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.EMAIL_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.GENDER_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.IMAGE_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.NAME_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.NAV_DRIVER_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.PHONE_NUMBER_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.RANDOM_TEXT_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.REFRESH_BUTTON_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.USER_EMAIL_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.USER_LIST_ITEM_TAG
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class FullUiTest {
    @get:Rule
    val rule = createUltronComposeRule<MainActivity>()

    // Tests are invoked in alphabetical order
    @Test
    fun a_registerUserSignOutAndLoginTest() {
        MainActivityScreen {
            registerUser()
            signOut()
            errorRegisterUser()
            loginUser()
        }
    }

    @Test
    fun b_testBottomBars() {
        MainActivityScreen {
            checkBottomBar()
        }
    }

    @Test
    fun c_testMainViews() {
        MainActivityScreen {
            checkMainScreens()
        }
    }

    @Test
    fun d_testInfoViews() {
        MainActivityScreen {
            checkInfoScreens()
        }
    }

    @Test
    fun e_testSettingsViews() {
        MainActivityScreen {
            checkSettingsScreens()
        }
    }

    @Test
    fun f_testStatsViews() {
        MainActivityScreen {
            checkStatsScreens()
        }
    }

    @Test
    fun g_testAnimeImagesViews() {
        MainActivityScreen {
            checkAnimeImagesScreens()
        }
    }

    @Test
    fun h_testUsersViews() {
        MainActivityScreen {
            checkUsersScreens()
        }
    }
}

private object MainActivityScreen : Screen<MainActivityScreen>() {
    // BottomBar
    private val homeBottomBtn = hasText("Home")
    private val infoBottomBtn = hasText("Info")
    private val settingsBottomBar = hasText("Settings")

    // Login Screen
    private val email = hasTestTag(EMAIL_TAG)
    private val password = hasTestTag(TestTags.PASSWORD_TAG)
    private val loginButton = hasText("Увійти")
    private val registerButton = hasText("Зареєструватися")
    private val popUpUserLoggedText = hasText("Користувач увійшов в систему")
    private val popUpBtn = hasText("OK")
    private const val EMAIL = "testuser@gmail.com"
    private const val PASSWORD = "12345678"

    // Nav Driver
    private val navDriver = hasTestTag(NAV_DRIVER_TAG)
    private val statsScreen = hasText("Statistics")
    private val animeImagesScreen = hasText("Random anime images")
    private val usersScreen = hasText("Users")

    // Info
    private val emailInfoUserText = hasTestTag(USER_EMAIL_TAG)
    private val infoFirstTitle = hasText("Info First Screen")
    private val infoSecondTitle = hasText("Info second screen")
    private val backInfo = hasText("Back to main info")

    // Register Screen
    private val popUpRegisterText = hasText("Користувач зареєстрований")
    private val popUpErrorText = hasText("Відбулась помилка")

    // Main Screen
    private val mainText = hasTestTag(RANDOM_TEXT_TAG)
    private val mainTitle = hasText("Main Screen")
    private val mainFirstTitle = hasText("Main First Screen")
    private val mainSecondTitle = hasText("Main Second Screen")
    private val nextScreenBtn = hasText("Next Screen")
    private val backToMain = hasText("Back to main")

    // Settings
    private val signOutButton = hasText("Sign Out")
    private val settingsFirstTitle = hasText("Settings First Screen")
    private val settingsSecondTitle = hasText("Second Settings Screen")
    private val backSettings = hasText("Back to Main Settings")

    // Statistics
    private val chart = hasTestTag(CHART_TAG)
    private val backChart = hasText("Back to main chart")

    // Anime Images
    private val animeImage = hasTestTag(IMAGE_TAG)
    private val animeMainTitle = hasText("Main Anime Page")
    private val animeFirstTitle = hasText("First Anime Page")
    private val animeSecondTitle = hasText("Second Anime Page")
    private val refreshButton = hasTestTag(REFRESH_BUTTON_TAG)

    // Users
    private val nameRow = hasTestTag(NAME_TAG)
    private val emailRow = hasTestTag(EMAIL_TAG)
    private val genderRow = hasTestTag(GENDER_TAG)
    private val phoneNumberRow = hasTestTag(PHONE_NUMBER_TAG)
    private val userImage = hasTestTag(IMAGE_TAG)

    // User List
    private val userListItem = composeList(hasTestTag(USER_LIST_ITEM_TAG))

    fun loginUser() {
        inputEmailText()
        inputPassword()
        loginClick()
        popUpHasLogged()
        mainText.assertIsDisplayed()
    }

    private fun inputEmailText() {
        email.assertIsDisplayed()
        email.inputText(EMAIL)
        email.assertTextContains(EMAIL)
    }

    private fun inputPassword() {
        password.assertIsDisplayed()
        password.inputText(PASSWORD)
        var str = ""
        repeat(PASSWORD.length) {
            str += "•"
        }
        password.assertTextContains(str)
    }

    fun signOut() {
        settingsBottomBar.click()
        signOutButton.click()
        email.assertIsDisplayed()
    }

    fun registerUser() {
        val emailText = generateRandomEmail()
        registerClick()
        email.inputText(emailText)
        password.inputText("12345678")

        registerButton.click()

        popUpBtn.assertIsDisplayed()
        popUpRegisterText.assertIsDisplayed()

        popUpBtn.click()

        mainText.assertIsDisplayed()
    }

    fun errorRegisterUser() {
        registerClick()
        email.inputText("testuser@gmail.com")
        password.inputText("12348941")

        registerButton.click()

        popUpErrorText.assertIsDisplayed()
        popUpBtn.click()

        loginButton.click()
    }

    private fun registerClick() {
        registerButton.assertIsDisplayed()
        registerButton.click()
    }

    private fun loginClick() {
        loginButton.assertIsDisplayed()
        loginButton.click()
    }

    private fun popUpHasLogged() {
        popUpUserLoggedText.assertIsDisplayed()
        popUpBtn.assertIsDisplayed()
        popUpBtn.click()
        popUpBtn.assertDoesNotExist()
    }

    fun checkBottomBar() {
        homeBottomBtn.assertIsDisplayed()
        infoBottomBtn.assertIsDisplayed()
        settingsBottomBar.assertIsDisplayed()
        infoBottomBtn.click()
        homeBottomBtn.click()
        settingsBottomBar.click()
        infoBottomBtn.click()
        homeBottomBtn.click()
    }

    fun checkMainScreens() {
        mainText.assertIsDisplayed()
        mainTitle.assertIsDisplayed()
        nextScreenBtn.click()
        mainText.assertIsDisplayed()
        mainFirstTitle.assertIsDisplayed()
        nextScreenBtn.click()
        mainText.assertIsDisplayed()
        mainSecondTitle.assertIsDisplayed()
        backToMain.assertIsDisplayed()
        backToMain.click()
        nextScreenBtn.assertIsDisplayed()
    }

    fun checkInfoScreens() {
        infoBottomBtn.click()
        emailInfoUserText.assertIsDisplayed()
        nextScreenBtn.click()
        mainText.assertIsDisplayed()
        infoFirstTitle.assertIsDisplayed()
        nextScreenBtn.click()
        mainText.assertIsDisplayed()
        infoSecondTitle.assertIsDisplayed()
        backInfo.click()
    }

    fun checkSettingsScreens() {
        settingsBottomBar.click()
        signOutButton.assertIsDisplayed()
        nextScreenBtn.click()
        settingsFirstTitle.assertIsDisplayed()
        mainText.assertIsDisplayed()
        nextScreenBtn.click()
        settingsSecondTitle.assertIsDisplayed()
        backSettings.assertIsDisplayed()
        backSettings.click()
        signOutButton.assertIsDisplayed()
    }

    fun checkStatsScreens() {
        navDriver.click()
        statsScreen.click()
        chart.assertIsDisplayed()
        nextScreenBtn.click()
        chart.assertIsDisplayed()
        nextScreenBtn.click()
        chart.assertIsDisplayed()
        backChart.assertIsDisplayed()
        backChart.click()
    }

    fun checkAnimeImagesScreens() {
        navDriver.click()
        animeImagesScreen.click()
        animeMainTitle.assertIsDisplayed()
        animeImage.assertIsDisplayed()
        refreshButton.click()
        animeImage.assertIsDisplayed()
        nextScreenBtn.click()
        animeFirstTitle.assertIsDisplayed()
        animeImage.assertIsDisplayed()
        refreshButton.click()
        animeImage.assertIsDisplayed()
        nextScreenBtn.click()
        animeSecondTitle.assertIsDisplayed()
        animeImage.assertIsDisplayed()
        refreshButton.click()
        animeImage.assertIsDisplayed()
        backToMain.assertIsDisplayed()
        backToMain.click()
    }

    fun checkUsersScreens() {
        navDriver.click()
        usersScreen.click()
        nameRow.assertIsDisplayed()
        emailRow.assertIsDisplayed()
        genderRow.assertIsDisplayed()
        phoneNumberRow.assertIsDisplayed()
        userImage.assertIsDisplayed()
        nextScreenBtn.click()
        nameRow.assertIsDisplayed()
        emailRow.assertIsDisplayed()
        genderRow.assertIsDisplayed()
        phoneNumberRow.assertIsDisplayed()
        userImage.assertIsDisplayed()
        nextScreenBtn.click()
        userListItem.assertIsDisplayed()
        backToMain.assertIsDisplayed()
        backToMain.click()
    }

    private fun generateRandomEmail(): String {
        val allowedChars = ('a'..'z') + ('0'..'9') + listOf('.', '_', '-')
        val localPartLength = (6..10).random()

        val localPart =
            (1..localPartLength)
                .map { allowedChars.random() }
                .joinToString("")

        return "$localPart@gmail.com"
    }
}
