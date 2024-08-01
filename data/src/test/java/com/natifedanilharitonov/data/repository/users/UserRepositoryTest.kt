package com.natifedanilharitonov.data.repository.users

import android.graphics.Bitmap
import com.natifeuaandroid.domainmodule.model.DomainName
import com.natifeuaandroid.domainmodule.model.DomainPicture
import com.natifeuaandroid.domainmodule.model.DomainUser
import com.natifeuaandroid.domainmodule.repository.UsersRepository

import junit.framework.TestCase.assertEquals
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock

class UserRepositoryTest {
    private val repositoryAccess: UsersRepository = MockUserRepositoryAccess()
    private val repositoryError: UsersRepository = MockUserRepositoryError()

    @Test
    fun `get users access`() =
        runTest {
            val bitmap = mock<Bitmap>()
            val expected =
                persistentListOf(
                    DomainUser(
                        gender = "male",
                        picture = DomainPicture("image"),
                        name = DomainName("Mr", "Mock", "Mock"),
                        email = "mock@mock.com",
                        phone = "+380332001020",
                    ),
                    DomainUser(
                        gender = "female",
                        picture = DomainPicture("image"),
                        name = DomainName("Mr", "Mocki", "Mock"),
                        email = "mock@moc1k.com",
                        phone = "+3803320010f0",
                    ),
                )
            val actual = repositoryAccess.getUsers()
            assert(actual[0].email == expected[0].email)
            assert(actual[0].gender == expected[0].gender)
            assert(actual[0].phone == expected[0].phone)
            assert(actual[1].email == expected[1].email)
            assert(actual[1].gender == expected[1].gender)
            assert(actual[1].phone == expected[1].phone)
        }

    @Test
    fun `get users error`() =
        runTest {
            val actual = repositoryError.getUsers()
            assert(actual.isEmpty())
        }

    @Test
    fun `get user access`() =
        runTest {
            val bitmap = mock<Bitmap>()
            val expected =
                DomainUser(
                    gender = "male",
                    picture = DomainPicture("image"),
                    name = DomainName("Mr", "Mock", "Mock"),
                    email = "mock@mock.com",
                    phone = "+380332001020",
                )
            val actual = repositoryAccess.getUser()
            assertEquals(expected.email, actual?.email)
            assertEquals(expected.gender, actual?.gender)
            assertEquals(expected.phone, actual?.phone)
        }

    @Test
    fun `get user error`() =
        runTest {
            val actual = repositoryError.getUser()
            assert(actual == null)
        }
}

private class MockUserRepositoryError : UsersRepository {
    override suspend fun getUsers(): PersistentList<DomainUser> {
        return persistentListOf()
    }

    override suspend fun getUser(): DomainUser? {
        return null
    }
}

private class MockUserRepositoryAccess : UsersRepository {
    override suspend fun getUsers(): PersistentList<DomainUser> {
        val bitmap = mock<Bitmap>()
        return persistentListOf(
            DomainUser(
                gender = "male",
                picture = DomainPicture("image"),
                name = DomainName("Mr", "Mock", "Mock"),
                email = "mock@mock.com",
                phone = "+380332001020",
            ),
            DomainUser(
                gender = "female",
                picture = DomainPicture("image"),
                name = DomainName("Mr", "Mocki", "Mock"),
                email = "mock@moc1k.com",
                phone = "+3803320010f0",
            ),
        )
    }

    override suspend fun getUser(): DomainUser {
        val bitmap = mock<Bitmap>()
        return DomainUser(
            gender = "male",
            picture = DomainPicture("image"),
            name = DomainName("Mr", "Mock", "Mock"),
            email = "mock@mock.com",
            phone = "+380332001020",
        )
    }
}
