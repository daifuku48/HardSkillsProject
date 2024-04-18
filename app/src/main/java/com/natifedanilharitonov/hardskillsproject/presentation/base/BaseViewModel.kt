package com.natifedanilharitonov.hardskillsproject.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<State : UiState, Event : UiEvent, Model : UiModel>(
    private val reducer: Reducer<State, Event, Model>,
    private val useCase: Set<UseCase<State, Event>>,
    private val navigator: Navigator,
) : ViewModel() {
    private val initState by lazy {
        createInitState()
    }

    protected val state: MutableStateFlow<State> = MutableStateFlow(initState)

    val uiState: StateFlow<Model> =
        state.map { state ->
            reducer.mapToUiModel(state)
        }.stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            initialValue = reducer.mapToUiModel(createInitState()),
        )

    protected abstract fun createInitState(): State

    protected fun navigate(
        route: String,
        navOptions: NavOptions? = null,
    ) {
        navigator.navigate(route, navOptions)
    }

    protected fun popBackStack(
        destination: String,
        inclusive: Boolean,
    ) {
        navigator.popBackStack(destination, inclusive)
    }

    protected fun popBack() {
        navigator.popBack()
    }

    protected fun handleEvent(event: Event) {
        state.value = reducer.reduce(state = state.value, event = event)
        useCase.filter { it.canHandle(event) }.forEach { useCase ->
            viewModelScope.launch(Dispatchers.IO) {
                val result = useCase.execute(state.value, event)
                withContext(Dispatchers.Main) {
                    handleEvent(result)
                }
            }
        }
    }
}
