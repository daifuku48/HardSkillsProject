package com.natifedanilharitonov.domain.userRandomSecond

import com.natifedanilharitonov.domain.features.userRandomFirst.UserResult
import com.natifedanilharitonov.domain.features.userRandomSecond.GetRandomUserSecondUseCase
import com.natifedanilharitonov.domain.features.userRandomSecond.UserRandomSecondEvent
import com.natifedanilharitonov.domain.features.userRandomSecond.UserRandomSecondState
import com.natifedanilharitonov.domain.model.DomainName
import com.natifedanilharitonov.domain.model.DomainPicture
import com.natifedanilharitonov.domain.model.DomainUser
import com.natifedanilharitonov.domain.repository.UsersRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetRandomUserSecondUseCaseTest {
    private lateinit var useCase: GetRandomUserSecondUseCase

    @Mock
    private lateinit var repository: UsersRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetRandomUserSecondUseCase(repository)
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
                    picture = DomainPicture(Mockito.mock()),
                )
            Mockito.`when`(repository.getUser()).thenReturn(user)

            val event =
                useCase.execute(UserRandomSecondState(), UserRandomSecondEvent.GetRandomUserInfo)

            if (event is UserRandomSecondEvent.RandomUserInfoIsReceived) {
                if (event.userResult is UserResult.Model) {
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
            Mockito.`when`(repository.getUser()).thenReturn(user)

            val event =
                useCase.execute(UserRandomSecondState(), UserRandomSecondEvent.GetRandomUserInfo)

            if (event is UserRandomSecondEvent.RandomUserInfoIsReceived) {
                if (event.userResult is UserResult.Error) {
                    assert(true)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `valid event`() =
        runTest {
            assert(useCase.canHandle(UserRandomSecondEvent.GetRandomUserInfo))
        }

    @Test
    fun `invalid event`() =
        runTest {
            assert(!useCase.canHandle(UserRandomSecondEvent.ErrorEvent))
            assert(!useCase.canHandle(UserRandomSecondEvent.RandomUserInfoIsReceived(UserResult.Error)))
        }
}
