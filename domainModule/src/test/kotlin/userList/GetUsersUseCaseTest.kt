package userList

import com.natifeuaandroid.domainmodule.features.userList.UserListEvent
import com.natifeuaandroid.domainmodule.features.userList.UserListState
import com.natifeuaandroid.domainmodule.features.userList.useCases.GetUsersUseCase
import com.natifeuaandroid.domainmodule.model.DomainUser
import com.natifeuaandroid.domainmodule.repository.UsersRepository
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetUsersUseCaseTest {
    private lateinit var useCase: GetUsersUseCase

    @Mock
    private lateinit var repository: UsersRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetUsersUseCase(repository)
    }

    @Test
    fun `get user list access`() =
        runTest {
            val list = persistentListOf<DomainUser>()
            `when`(repository.getUsers()).thenReturn(list)

            val event = useCase.execute(UserListState(), UserListEvent.GetUsersEvent)

            if (event is UserListEvent.UsersIsReceived) {
                if (event.userList != null) {
                    assert(true)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `get user list error`() =
        runTest {
            val list = persistentListOf<DomainUser>()
            `when`(repository.getUsers()).thenReturn(list)

            val event = useCase.execute(UserListState(), UserListEvent.GetUsersEvent)

            if (event is UserListEvent.UsersIsReceived) {
                if (event.userList == null) {
                    assert(true)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `valid event`() =
        runTest {
            assert(useCase.canHandle(UserListEvent.GetUsersEvent))
        }

    @Test
    fun `invalid event`() =
        runTest {
            assert(!useCase.canHandle(UserListEvent.ErrorEvent))
            assert(!useCase.canHandle(UserListEvent.UsersIsReceived(null, 1)))
            assert(!useCase.canHandle(UserListEvent.PagingUserIsReceived(persistentListOf(), 1)))
            assert(!useCase.canHandle(UserListEvent.PagingToEndEvent))
        }
}
