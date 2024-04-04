package com.natifedanilharitonov.hardskillsproject.presentation.main_second

import androidx.navigation.NavOptions
import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.main_second.MainSecondEvent
import com.natifedanilharitonov.domain.features.main_second.MainSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.base.BaseViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.Navigator
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

class MainSecondViewModelImpl(
    reducer: Reducer<MainSecondState, MainSecondEvent, MainSecondUiState>,
    useCases: Set<UseCase<MainSecondState, MainSecondEvent>>,
    navigator: Navigator
) : BaseViewModel<MainSecondState, MainSecondEvent, MainSecondUiState>(
    reducer, useCases, navigator
), MainSecondViewModel {

    init {
        handleEvent(MainSecondEvent.GetMainTextEvent)
    }

    override fun createInitState(): MainSecondState =
        MainSecondState()

    override fun backToMain() {
        val navOptions = NavOptions.Builder().setPopUpTo(
                route = Screen.MainSecondMockScreen.route, inclusive = true
            ).build()
        navigate(Screen.MainScreen.route, navOptions)
    }
}