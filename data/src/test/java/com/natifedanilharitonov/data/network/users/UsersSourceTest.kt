package com.natifedanilharitonov.data.network.users

import com.natifedanilharitonov.data.network.users.model.NetworkName
import com.natifedanilharitonov.data.network.users.model.NetworkPicture
import com.natifedanilharitonov.data.network.users.model.NetworkUser
import com.natifedanilharitonov.data.network.users.model.NetworkUserResult
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class UsersSourceTest {
    private lateinit var userSource: UsersSourceImpl
    private val usersInstance = MockUsersInstance()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        userSource = UsersSourceImpl(usersInstance)
    }

    @Test
    fun `get users access`() =
        runTest {
            val users = usersInstance.getUsers().users


            assertEquals(users.size, users.size)

            users.zip(users).forEach { (expected, actual) ->
                assertEquals(expected.email, actual.email)
                assertEquals(expected.gender, actual.gender)
            }
        }

    @Test
    fun `get user access`() =
        runTest {
            val user = usersInstance.getUser()
            val expectedUser = mockUser
            val actualUser = user.users.first()

            assertEquals(expectedUser.email, actualUser.email)
            assertEquals(expectedUser.gender, actualUser.gender)
            assertEquals(expectedUser.name, actualUser.name)
            assertEquals(expectedUser.picture, actualUser.picture)
            assertEquals(expectedUser.phone, actualUser.phone)
        }
}

private val mockUsers =
    listOf(
        NetworkUser(
            gender = "male",
            name =
                NetworkName(
                    first = "mock",
                    last = "last mock",
                    title = "title mock",
                ),
            email = "mock3@gmail.com",
            phone = "+3809977788999",
            picture = NetworkPicture("url"),
        ),
        NetworkUser(
            gender = "female",
            name =
                NetworkName(
                    first = "mock",
                    last = "mock last",
                    title = "mock title",
                ),
            email = "mock2@gmail.com",
            phone = "+380993332134",
            picture = NetworkPicture("url"),
        ),
        NetworkUser(
            gender = "female",
            name =
                NetworkName(
                    first = "mock mock",
                    last = "last mock",
                    title = "title mock",
                ),
            email = "mock1@gmail.com",
            phone = "+380992223311",
            picture = NetworkPicture("url"),
        ),
        NetworkUser(
            gender = "male",
            name =
                NetworkName(
                    first = "mock",
                    last = "last mock",
                    title = "title mock",
                ),
            email = "mock4@gmail.com",
            phone = "+380999999999",
            picture = NetworkPicture("url"),
        ),
        NetworkUser(
            gender = "male",
            name =
                NetworkName(
                    first = "mock",
                    last = "last mock",
                    title = "title mock",
                ),
            email = "mock@gmail.com",
            phone = "+380996232617",
            picture = NetworkPicture("url"),
        ),
    )

private val mockUser =
    NetworkUser(
        gender = "male",
        name =
            NetworkName(
                first = "mock",
                last = "last mock",
                title = "title mock",
            ),
        email = "mock3@gmail.com",
        phone = "+3809977788999",
        picture = NetworkPicture("url"),
    )

private class MockUsersInstance : UsersRetrofitInstance {
    override suspend fun getUsers(results: String): NetworkUserResult {
        return NetworkUserResult(mockUsers)
    }

    override suspend fun getUser(results: String): NetworkUserResult {
        return NetworkUserResult(listOf(mockUser))
    }
}
