package com.natifedanilharitonov.hardskillsproject.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.reflect.KClass

abstract class BaseViewModel<State, Event : Any, UiState>(
    private val reducer: com.natifeuaandroid.coremodule.Reducer<State, Event>,
    private val useCase: Set<com.natifeuaandroid.coremodule.UseCase<State, Event>>,
    private val navigator: Navigator,
) : ViewModel() {
    private val handledEvents: MutableList<KClass<out Event>> = arrayListOf()
    protected val state: MutableStateFlow<State> = MutableStateFlow(reducer.createInitialState())

    val uiState: StateFlow<UiState> =
        state
            .map { state ->
                mapToUiModel(state)
            }.stateIn(
                viewModelScope,
                SharingStarted.Lazily,
                initialValue = mapToUiModel(reducer.createInitialState()),
            )

    abstract fun mapToUiModel(state: State): UiState

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

    protected fun addSpecialEvent(event: KClass<out Event>) {
        handledEvents.add(event)
    }

    abstract fun handleSpecialEvents(event: Event)

    protected fun handleEvent(event: Event) {
        state.value = reducer.reduce(state = state.value, event = event)
        if (handledEvents.any { it == event::class }) {
            handleSpecialEvents(event)
        }
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
