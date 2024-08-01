package com.natifedanilharitonov.domain.userList

import com.natifeuaandroid.domainmodule.features.userList.UserListEvent
import com.natifeuaandroid.domainmodule.features.userList.UserListState
import com.natifeuaandroid.domainmodule.features.userList.useCases.AddUsersUseCase
import com.natifeuaandroid.domainmodule.repository.UsersRepository
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class AddUsersUseCaseTest {
    private lateinit var useCase: AddUsersUseCase

    @Mock
    private lateinit var repository: UsersRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = AddUsersUseCase(repository)
    }

    @Test
    fun `add users access`() =
        runTest {
            `when`(repository.getUsers()).thenReturn(persistentListOf(mock(), mock(), mock()))
            val event =
                useCase.execute(
                    UserListState(userList = persistentListOf()),
                    UserListEvent.PagingToEndEvent,
                )

            if (event is UserListEvent.UsersIsReceived) {
                if (event.userList != null) {
                    assert(true)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `add users error`() =
        runTest {
            `when`(repository.getUsers()).thenReturn(persistentListOf())
            val event =
                useCase.execute(
                    UserListState(userList = persistentListOf()),
                    UserListEvent.PagingToEndEvent,
                )

            if (event is UserListEvent.ErrorEvent) {
                assert(true)
            } else {
                assert(false)
            }
        }

    @Test
    fun `valid event`() =
        runTest {
            assert(useCase.canHandle(UserListEvent.PagingToEndEvent))
        }

    @Test
    fun `invalid event`() =
        runTest {
            assert(!useCase.canHandle(UserListEvent.GetUsersEvent))
            assert(!useCase.canHandle(UserListEvent.ErrorEvent))
            assert(!useCase.canHandle(UserListEvent.UsersIsReceived(persistentListOf(), 1)))
        }
}
