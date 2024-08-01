package userRandomFirst

import com.natifeuaandroid.domainmodule.features.userRandomFirst.UserRandomFirstEvent
import com.natifeuaandroid.domainmodule.features.userRandomFirst.UserRandomFirstState
import com.natifeuaandroid.domainmodule.features.userRandomFirst.useCases.GetRandomUserFirstUseCase
import com.natifeuaandroid.domainmodule.model.DomainName
import com.natifeuaandroid.domainmodule.model.DomainPicture
import com.natifeuaandroid.domainmodule.model.DomainUser
import com.natifeuaandroid.domainmodule.repository.UsersRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
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
                    picture = DomainPicture("image"),
                )
            `when`(repository.getUser()).thenReturn(user)

            val event =
                useCase.execute(UserRandomFirstState(), UserRandomFirstEvent.GetRandomUserInfoEvent)

            if (event is UserRandomFirstEvent.RandomUserIsReceived) {
                if (event.user == user) {
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

            if (event is UserRandomFirstEvent.ShowUserErrorEvent) {
                assert(true)
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
            assert(!useCase.canHandle(UserRandomFirstEvent.RandomUserIsReceived(null)))
        }
}
