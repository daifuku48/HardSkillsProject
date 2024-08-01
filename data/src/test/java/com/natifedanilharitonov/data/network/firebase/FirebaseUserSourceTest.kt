package com.natifedanilharitonov.data.network.firebase

import com.natifedanilharitonov.data.network.firebase.model.FirebaseUserNetwork
import com.natifeuaandroid.domainmodule.Utils.EMAIL_PATTERN
import com.natifeuaandroid.domainmodule.Utils.PASSWORD_PATTERN

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FirebaseUserSourceTest {
    private lateinit var source: FirebaseUserSource

    @Test
    fun `login user access`() =
        runTest {
            source = MockFirebaseSource(MockFirebaseAuth.MockFirebaseAuthImpl())
            val result1 = source.login("email@gmail.com", "12345678")
            val result2 = source.login("usermock@gmail.com", "abcd13454")
            assert(result1)
            assert(result2)
        }

    @Test
    fun `login user error`() =
        runTest {
            source = MockFirebaseSource(MockFirebaseAuth.MockFirebaseAuthImpl())
            val result1 = source.login("email.com", "12345678")
            val result2 = source.login("email@gmail.com", "1234")
            val result3 = source.login("email.com", "mock")
            assert(!result1)
            assert(!result2)
            assert(!result3)
        }

    @Test
    fun `register user success`() =
        runTest {
            source = MockFirebaseSource(MockFirebaseAuth.MockFirebaseAuthImpl())
            val result1 = source.register("email@gmail.com", "12345678")
            val result2 = source.register("usermock@gmail.com", "abcd13454")
            assert(result1)
            assert(result2)
        }

    @Test
    fun `register user error`() =
        runTest {
            source = MockFirebaseSource(MockFirebaseAuth.MockFirebaseAuthImpl())
            val result1 = source.register("email.com", "12345678")
            val result2 = source.register("email@gmail.com", "1234")
            val result3 = source.register("email.com", "mock")
            assert(!result1)
            assert(!result2)
            assert(!result3)
        }

    @Test
    fun `get user access`() =
        runTest {
            source = MockFirebaseSource(MockFirebaseAuth.MockFirebaseAuthImpl())
            source.login("mock@gmail.com", "12345678")
            assertEquals(source.getUser()?.email, "mock@gmail.com")
        }

    @Test
    fun `get user error`() =
        runTest {
            source = MockFirebaseSource(MockFirebaseAuth.MockFirebaseAuthImpl())
            assertEquals(source.getUser(), null)
        }

    @Test
    fun `sign out success`() =
        runTest {
            source = MockFirebaseSource(MockFirebaseAuth.MockFirebaseAuthImpl())
            source.login("email@gmail.com", "12345678")
            source.signOut()
            assert((source as MockFirebaseSource).auth.signOutState is SignOutResult.UserIsSignOut)
        }

    @Test
    fun `sign out error`() =
        runTest {
            source = MockFirebaseSource(MockFirebaseAuth.MockFirebaseAuthImpl())
            source.signOut()
            assert((source as MockFirebaseSource).auth.signOutState is SignOutResult.UserError)
        }
}

private class MockFirebaseSource(val auth: MockFirebaseAuth) : FirebaseUserSource {
    override suspend fun register(
        email: String,
        password: String,
    ): Boolean {
        return suspendCoroutine { continuation ->
            val result = auth.createUserWithEmailAndPasswordSuccess(email, password)
            when (result) {
                is MockAuthResult.AuthFailure -> continuation.resume(false)
                is MockAuthResult.AuthSuccess -> continuation.resume(true)
            }
        }
    }

    override suspend fun login(
        email: String,
        password: String,
    ): Boolean {
        return suspendCoroutine { continuation ->
            val result = auth.signInWithEmailAndPasswordSuccess(email, password)
            when (result) {
                is MockAuthResult.AuthFailure -> continuation.resume(false)
                is MockAuthResult.AuthSuccess -> continuation.resume(true)
            }
        }
    }

    override suspend fun getUser(): FirebaseUserNetwork? {
        val user = auth.getCurrentUser()
        return if (user != null) {
            if (user is MockFireBaseUser.CurrentUser) {
                FirebaseUserNetwork(email = user.email)
            } else {
                null
            }
        } else {
            null
        }
    }

    override fun signOut() {
        auth.signOut()
    }
}

private interface MockFirebaseAuth {
    var signOutState: SignOutResult

    fun createUserWithEmailAndPasswordSuccess(
        email: String,
        password: String,
    ): MockAuthResult

    fun signInWithEmailAndPasswordSuccess(
        email: String,
        password: String,
    ): MockAuthResult

    fun getCurrentUser(): MockFireBaseUser?

    fun signOut()

    class MockFirebaseAuthImpl : MockFirebaseAuth {
        private var userHasLogged: Boolean = false
        override var signOutState: SignOutResult = SignOutResult.Pending

        override fun createUserWithEmailAndPasswordSuccess(
            email: String,
            password: String,
        ): MockAuthResult {
            return if (Regex(EMAIL_PATTERN).matches(email) &&
                Regex(PASSWORD_PATTERN).matches(
                    password,
                )
            ) {
                userHasLogged = true
                MockAuthResult.AuthSuccess
            } else {
                MockAuthResult.AuthFailure(Exception("user is not success"))
            }
        }

        override fun signInWithEmailAndPasswordSuccess(
            email: String,
            password: String,
        ): MockAuthResult {
            return if (Regex(EMAIL_PATTERN).matches(email) &&
                Regex(PASSWORD_PATTERN).matches(
                    password,
                )
            ) {
                userHasLogged = true
                MockAuthResult.AuthSuccess
            } else {
                MockAuthResult.AuthFailure(Exception("user is not success"))
            }
        }

        override fun getCurrentUser(): MockFireBaseUser? {
            return if (userHasLogged) {
                MockFireBaseUser.CurrentUser("mock@gmail.com")
            } else {
                null
            }
        }

        override fun signOut() {
            if (userHasLogged) {
                userHasLogged = false
                signOutState = SignOutResult.UserIsSignOut
            } else {
                signOutState = SignOutResult.UserError
            }
        }
    }
}

private interface MockAuthResult {
    data object AuthSuccess : MockAuthResult

    data class AuthFailure(val exception: Exception) : MockAuthResult
}

private interface MockFireBaseUser {
    data class CurrentUser(val email: String) : MockFireBaseUser
}

private interface SignOutResult {
    data object Pending : SignOutResult

    data object UserIsSignOut : SignOutResult

    data object UserError : SignOutResult
}

private interface MockFirebaseUserSource {
    suspend fun register(
        email: String,
        password: String,
    ): Boolean

    suspend fun login(
        email: String,
        password: String,
    ): Boolean

    suspend fun getUser(): MockFireBaseUser?

    fun signOut()
}
