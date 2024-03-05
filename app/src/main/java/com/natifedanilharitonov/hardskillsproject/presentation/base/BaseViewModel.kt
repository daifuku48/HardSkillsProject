package com.natifedanilharitonov.hardskillsproject.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UiEvent
import com.natifedanilharitonov.hardskillsproject.core.UiState
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.navigation.Navigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : UiState, Event : UiEvent>(
    private val reducer: Reducer<State, Event>,
    private val useCase: Set<UseCase<State, Event>>,
    private val navigator: Navigator
) : ViewModel() {

    private val initState by lazy {
        createInitState()
    }

    private val initCaughtEvents by lazy {
        createCaughtEvents()
    }

    private val _state: MutableStateFlow<State> = MutableStateFlow(initState)
    val state get() = _state.asStateFlow()

    private val caughtEvents: MutableStateFlow<MutableSet<Event>> =
        MutableStateFlow(initCaughtEvents)

    protected abstract fun createInitState(): State

    protected fun addSpecialEvent(event: Event) {
        caughtEvents.value.add(event)
    }

    private fun createCaughtEvents(): MutableSet<Event> {
        return mutableSetOf()
    }

    protected fun addCaughtEvent(event: Event) {
        caughtEvents.value.add(event)
    }

    protected fun navigate(route: String, navOptions: NavOptions? = null) {
        navigator.navigate(route, navOptions)
    }

    protected fun popBack(){
        navigator.popBack()
    }

    protected abstract fun handleCaughtEvent(event: Event)

    fun handle(event: Event) {
        _state.value = reducer.reduce(state = _state.value, event = event)
        if (caughtEvents.value.contains(event)) {
            handleCaughtEvent(event)
        }
        useCase.filter { it.canHandle(event) }.forEach { useCase ->
            viewModelScope.launch(Dispatchers.IO) {
                val result = useCase.execute(uiState.value, event)
                withContext(Dispatchers.Main) {
                    handleEvent(result)
                }
            }
        }
    }
}