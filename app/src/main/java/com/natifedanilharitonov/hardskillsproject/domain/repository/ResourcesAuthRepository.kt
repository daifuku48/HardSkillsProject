package com.natifedanilharitonov.hardskillsproject.domain.repository

interface ResourcesAuthRepository {
    fun getEmailLabel(): String
    fun getEmailErrorLabel(): String
    fun getPasswordLabel(): String
    fun getPasswordErrorLabel(): String
    fun getNicknameLabel(): String
    fun getNicknameErrorLabel(): String
}