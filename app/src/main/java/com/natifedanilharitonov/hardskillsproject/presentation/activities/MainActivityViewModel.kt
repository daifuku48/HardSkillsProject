package com.natifedanilharitonov.hardskillsproject.presentation.activities

interface MainActivityViewModel {
    fun changeBottomState(bottomState: Boolean)
    fun navigateDrawerMenu(route: String)
    fun navigateBottomBarMenu(route: String, index: Int)
}