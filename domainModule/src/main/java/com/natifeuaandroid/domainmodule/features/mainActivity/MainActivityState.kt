package com.natifeuaandroid.domainmodule.features.mainActivity

data class MainActivityState(
    val bottomState: Boolean = false,
    val drawerState: Boolean = false,
    val startDestination: String? = null,
    val bottomNavigationSelectedItem: Int = 0,
)
