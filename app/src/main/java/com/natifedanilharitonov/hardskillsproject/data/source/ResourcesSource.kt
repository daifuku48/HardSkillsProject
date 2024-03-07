package com.natifedanilharitonov.hardskillsproject.data.source

interface ResourcesSource {
    fun getNicknameLabel(): String
    fun getNicknameErrorLabel(): String
    fun getEmailLabel(): String
    fun getEmailErrorLabel(): String
    fun getPasswordLabel(): String
    fun getPasswordErrorLabel(): String
}