package com.natifedanilharitonov.hardskillsproject.animeAnimeRandom.register

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
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.EmailLabelState
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.PasswordLabelState
import com.natifedanilharitonov.hardskillsproject.presentation.registration.components.RegistrationContainerView
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.EMAIL_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.PASSWORD_TAG
import org.junit.Rule
import org.junit.Test

class RegisterContainerTest {
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
            RegistrationContainerView(
                email = email,
                emailChanged = {
                    email = it
                },
                password = password,
                passwordChanged = {
                    password = it
                },
                registerClick = { },
                loginClick = { },
                registerButtonEnabled = true,
                emailLabel = EmailLabelState.ValidEmailLabel,
                passwordLabel = PasswordLabelState.ErrorPassword,
                userLogDialogState = false,
                onConfirmUserLogDialogState = { },
                errorDialogState = false,
                onConfirmErrorDialogState = { },
                pending = false,
            )
        }

        RegisterScreenObjects {
            testTextPassword()
            testTextEmail()
            buttonIsDisplayed()
        }
    }

    @Test
    fun testLoggedPopUp() {
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
            RegistrationContainerView(
                email = email,
                emailChanged = {
                    email = it
                },
                password = password,
                passwordChanged = {
                    password = it
                },
                registerClick = {
                    showPopUp = true
                },
                loginClick = { },
                registerButtonEnabled = true,
                emailLabel = EmailLabelState.ValidEmailLabel,
                passwordLabel = PasswordLabelState.ErrorPassword,
                userLogDialogState = showPopUp,
                onConfirmUserLogDialogState = { showPopUp = false },
                errorDialogState = false,
                onConfirmErrorDialogState = { },
                pending = false,
            )
        }

        RegisterScreenObjects {
            register()
            showLoggedPopUp()
        }
    }

    @Test
    fun testErrorPopUp() {
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
            RegistrationContainerView(
                email = email,
                emailChanged = {
                    email = it
                },
                password = password,
                passwordChanged = {
                    password = it
                },
                registerClick = {
                    showPopUp = true
                },
                loginClick = { },
                registerButtonEnabled = true,
                emailLabel = EmailLabelState.ValidEmailLabel,
                passwordLabel = PasswordLabelState.ErrorPassword,
                userLogDialogState = false,
                onConfirmUserLogDialogState = { showPopUp = false },
                errorDialogState = showPopUp,
                onConfirmErrorDialogState = { },
                pending = false,
            )
        }

        RegisterScreenObjects {
            register()
            showErrorPopUp()
        }
    }
}

private object RegisterScreenObjects : Screen<RegisterScreenObjects>() {
    private val emailText = hasTestTag(EMAIL_TAG)
    private val passwordText = hasTestTag(PASSWORD_TAG)
    private val registerBtn = hasText("Зареєструватися")
    private val loginBtn = hasText("Увійти")
    private val popUpText = hasText("Користувач зареєстрований")
    private val popUpBtn = hasText("OK")
    private val popUpError = hasText("Відбулась помилка")

    fun testTextEmail() {
        emailText.inputText("mock")
        emailText.assertTextContains("mock")
    }

    fun testTextPassword() {
        passwordText.inputText("mock")
        passwordText.assertTextContains("••••")
    }

    fun buttonIsDisplayed() {
        registerBtn.assertIsDisplayed()
        registerBtn.click()
        loginBtn.assertIsDisplayed()
        loginBtn.click()
    }

    fun register() {
        registerBtn.click()
    }

    fun showLoggedPopUp() {
        popUpBtn.assertIsDisplayed()
        popUpText.assertIsDisplayed()
        popUpBtn.click()
        popUpBtn.assertDoesNotExist()
    }

    fun showErrorPopUp() {
        popUpError.assertIsDisplayed()
        popUpBtn.assertIsDisplayed()
        popUpBtn.click()
        popUpBtn.assertDoesNotExist()
    }
}
