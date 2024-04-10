package com.natifedanilharitonov.domain.userRandomFirst

import com.natifedanilharitonov.domain.features.userRandomFirst.GetRandomUserFirstUseCase
import com.natifedanilharitonov.domain.features.userRandomFirst.UserRandomFirstEvent
import com.natifedanilharitonov.domain.features.userRandomFirst.UserRandomFirstState
import com.natifedanilharitonov.domain.features.userRandomFirst.UserResult
import com.natifedanilharitonov.domain.model.DomainName
import com.natifedanilharitonov.domain.model.DomainPicture
import com.natifedanilharitonov.domain.model.DomainUser
import com.natifedanilharitonov.domain.repository.UsersRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetRandomUserFirstUseCaseTest {
    private lateinit var useCase: GetRandomUserFirstUseCase

    @Mock
    private lateinit var repository: UsersRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetRandomUserFirstUseCase(repository)
    }

    @Test
    fun `get user access`() =
        runTest {
            val user =
                DomainUser(
                    gender = "male",
                    email = "mock@gmail.com",
                    name =
                        DomainName(
                            title = "Ms",
                            first = "Mock",
                            last = "Mockich",
                        ),
                    phone = "+380993332299",
                    picture = DomainPicture(mock()),
                )
            `when`(repository.getUser()).thenReturn(user)

            val event =
                useCase.execute(UserRandomFirstState(), UserRandomFirstEvent.GetRandomUserInfoEvent)

            if (event is UserRandomFirstEvent.RandomUserIsReceived) {
                if (event.user is UserResult.Model) {
                    assert(true)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `get user error`() =
        runTest {
            val user = null
            `when`(repository.getUser()).thenReturn(user)

            val event =
                useCase.execute(UserRandomFirstState(), UserRandomFirstEvent.GetRandomUserInfoEvent)

            if (event is UserRandomFirstEvent.RandomUserIsReceived) {
                if (event.user is UserResult.Error) {
                    assert(true)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `valid event`() =
        runTest {
            assert(useCase.canHandle(UserRandomFirstEvent.GetRandomUserInfoEvent))
        }

    @Test
    fun `invalid event`() =
        runTest {
            assert(!useCase.canHandle(UserRandomFirstEvent.ErrorEvent))
            assert(!useCase.canHandle(UserRandomFirstEvent.RandomUserIsReceived(UserResult.Error)))
        }
}
