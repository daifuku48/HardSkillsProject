package userRandomSecond

import com.natifeuaandroid.domainmodule.features.userRandomSecond.UserRandomSecondEvent
import com.natifeuaandroid.domainmodule.features.userRandomSecond.UserRandomSecondState
import com.natifeuaandroid.domainmodule.features.userRandomSecond.useCases.GetRandomUserSecondUseCase
import com.natifeuaandroid.domainmodule.model.DomainName
import com.natifeuaandroid.domainmodule.model.DomainPicture
import com.natifeuaandroid.domainmodule.model.DomainUser
import com.natifeuaandroid.domainmodule.repository.UsersRepository
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
                    picture = DomainPicture("image"),
                )
            Mockito.`when`(repository.getUser()).thenReturn(user)

            val event =
                useCase.execute(UserRandomSecondState(), UserRandomSecondEvent.GetRandomUserInfo)

            if (event is UserRandomSecondEvent.RandomUserInfoIsReceived) {
                if (event.userResult == user) {
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

            if (event is UserRandomSecondEvent.RandomUserErrorEvent) {
                assert(true)
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
            assert(!useCase.canHandle(UserRandomSecondEvent.RandomUserInfoIsReceived(null)))
        }
}
