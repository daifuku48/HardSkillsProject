package com.natifedanilharitonov.hardskillsproject.data.source.auth

interface ResourcesAuthSource {
    fun getNicknameLabel(): String
    fun getNicknameErrorLabel(): String
    fun getEmailLabel(): String
    fun getEmailErrorLabel(): String
    fun getPasswordLabel(): String
    fun getPasswordErrorLabel(): String
}