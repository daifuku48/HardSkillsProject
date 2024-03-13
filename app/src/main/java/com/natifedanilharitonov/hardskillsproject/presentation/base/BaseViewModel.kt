package com.natifedanilharitonov.hardskillsproject.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.core.Reducer
import com.natifedanilharitonov.hardskillsproject.core.UiEvent
import com.natifedanilharitonov.hardskillsproject.core.UiState
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<State : UiState, Event : UiEvent>(
    private val reducer: Reducer<State, Event>,
    private val useCase: Set<UseCase<State, Event>>,
    private val navigator: Navigator
) : ViewModel() {

    private val initState by lazy {
        createInitState()
    }

    private val _state: MutableStateFlow<State> = MutableStateFlow(initState)
    val state get() = _state.asStateFlow()

    protected abstract fun createInitState(): State

    private fun createCaughtEvents(): MutableSet<Event> {
        return mutableSetOf()
    }


    protected fun navigate(route: String, navOptions: NavOptions? = null) {
        navigator.navigate(route, navOptions)
    }

    protected fun popBack(){
        navigator.popBack()
    }

    protected fun handleEvent(event: Event) {
        _state.value = reducer.reduce(state = _state.value, event = event)
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