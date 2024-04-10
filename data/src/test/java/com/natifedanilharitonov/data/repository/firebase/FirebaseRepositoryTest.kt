package com.natifedanilharitonov.data.repository.firebase

import com.natifedanilharitonov.data.network.firebase.FirebaseUserSource
import com.natifedanilharitonov.data.network.firebase.model.FirebaseUserNetwork
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class FirebaseRepositoryTest {
    private lateinit var repository: FirebaseUserRepositoryImpl

    @Mock
    private lateinit var source: FirebaseUserSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = FirebaseUserRepositoryImpl(source)
    }

    @Test
    fun `register access`() =
        runTest {
            `when`(source.register("mock@gmail.com", "12345678")).thenReturn(true)
            assert(repository.register("mock@gmail.com", "12345678"))
        }

    @Test
    fun `register error`() =
        runTest {
            `when`(source.register("mockgmail.com", "12345678")).thenReturn(false)
            `when`(source.register("mock@gmail.com", "1234567")).thenReturn(false)
            assert(!repository.register("mockgmail.com", "12345678"))
            assert(!repository.register("mock@gmail.com", "1234567"))
        }

    @Test
    fun `login access`() =
        runTest {
            `when`(source.login("mock@gmail.com", "12345678")).thenReturn(true)
            assert(repository.login("mock@gmail.com", "12345678"))
        }

    @Test
    fun `login error`() =
        runTest {
            `when`(source.login("mockgmail.com", "12345678")).thenReturn(false)
            `when`(source.login("mock@gmail.com", "1234567")).thenReturn(false)
            assert(!repository.login("mockgmail.com", "12345678"))
            assert(!repository.login("mock@gmail.com", "1234567"))
        }

    @Test
    fun `get user`() =
        runTest {
            `when`(source.getUser()).thenReturn(FirebaseUserNetwork("mock@gmail.com"))
            assert(source.getUser() != null)
        }

    @Test
    fun `sign out`() =
        runTest {
            try {
                source.signOut()
                assert(true)
            } catch (e: Exception) {
                assert(false)
            }
        }
}
