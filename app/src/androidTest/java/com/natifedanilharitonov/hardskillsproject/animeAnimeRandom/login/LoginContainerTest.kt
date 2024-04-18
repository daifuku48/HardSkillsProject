package com.natifedanilharitonov.hardskillsproject.animeAnimeRandom.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import com.atiurin.ultron.core.compose.createDefaultUltronComposeRule
import com.atiurin.ultron.extensions.assertDoesNotExist
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.assertTextContains
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.inputText
import com.atiurin.ultron.page.Screen
import com.natifedanilharitonov.hardskillsproject.presentation.login.components.LoginContainerView
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.EmailLabelState
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.PasswordLabelState
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.EMAIL_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.PASSWORD_TAG
import org.junit.Rule
import org.junit.Test

class LoginContainerTest {
    @get:Rule
    val rule = createDefaultUltronComposeRule()

    @Test
    fun testView() {
        rule.setContent {
            var email by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }
            LoginContainerView(
                email = email,
                emailChanged = { text ->
                    email = text
                },
                password = password,
                passwordChanged = { text ->
                    password = text
                },
                emailLabel = EmailLabelState.ValidEmailLabel,
                passwordLabel = PasswordLabelState.ValidPassword,
                pending = false,
                userLogDialogState = false,
                onConfirmUserLogDialogState = {},
                onConfirmErrorDialogState = {},
                errorDialogState = false,
                loginButtonEnabled = true,
                loginClick = {},
                registerClick = {},
            )
        }
        LoginScreen {
            inputEmailText("mock")
            inputPassword("12345")
            loginClick()
            registerClick()
        }
    }

    @Test
    fun testPopUpUserLogged() {
        rule.setContent {
            var email by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }
            var showPopUp by remember {
                mutableStateOf(false)
            }
            LoginContainerView(
                email = email,
                emailChanged = { text ->
                    email = text
                },
                password = password,
                passwordChanged = { text ->
                    password = text
                },
                emailLabel = EmailLabelState.ValidEmailLabel,
                passwordLabel = PasswordLabelState.ValidPassword,
                pending = false,
                userLogDialogState = showPopUp,
                onConfirmUserLogDialogState = {
                    showPopUp = false
                },
                onConfirmErrorDialogState = {},
                errorDialogState = false,
                loginButtonEnabled = true,
                loginClick = {},
                registerClick = { showPopUp = true },
            )
        }
        LoginScreen {
            registerClick()
            popUpHasLogged()
        }
    }

    @Test
    fun testPopUpError() {
        rule.setContent {
            var email by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }
            var showPopUp by remember {
                mutableStateOf(false)
            }
            LoginContainerView(
                email = email,
                emailChanged = { text ->
                    email = text
                },
                password = password,
                passwordChanged = { text ->
                    password = text
                },
                emailLabel = EmailLabelState.ValidEmailLabel,
                passwordLabel = PasswordLabelState.ValidPassword,
                pending = false,
                userLogDialogState = false,
                onConfirmUserLogDialogState = {},
                onConfirmErrorDialogState = {
                    showPopUp = false
                },
                errorDialogState = showPopUp,
                loginButtonEnabled = true,
                loginClick = {},
                registerClick = { showPopUp = true },
            )
        }
        LoginScreen {
            registerClick()
            popUpError()
        }
    }
}

private object LoginScreen : Screen<LoginScreen>() {
    private val email = hasTestTag(EMAIL_TAG)
    private val password = hasTestTag(PASSWORD_TAG)
    private val loginButton = hasText("Увійти")
    private val registerButton = hasText("Зареєструватися")
    private val popUpUserLogged = hasText("Користувач увійшов в систему")
    private val popUpBtn = hasText("OK")
    private val popUpError = hasText("Відбулась помилка")

    fun inputEmailText(text: String) {
        email.assertIsDisplayed()
        email.inputText(text)
        email.assertTextContains(text)
    }

    fun inputPassword(text: String) {
        password.assertIsDisplayed()
        password.inputText(text)
        var str = ""
        repeat(text.length) {
            str += "•"
        }
        password.assertTextContains(str)
    }

    fun registerClick() {
        registerButton.assertIsDisplayed()
        registerButton.click()
    }

    fun loginClick() {
        loginButton.assertIsDisplayed()
        loginButton.click()
    }

    fun popUpHasLogged() {
        popUpUserLogged.assertIsDisplayed()
        popUpBtn.assertIsDisplayed()
        popUpBtn.click()
        popUpBtn.assertDoesNotExist()
    }

    fun popUpError() {
        popUpError.assertIsDisplayed()
        popUpBtn.assertIsDisplayed()
        popUpBtn.click()
        popUpBtn.assertDoesNotExist()
    }
}
