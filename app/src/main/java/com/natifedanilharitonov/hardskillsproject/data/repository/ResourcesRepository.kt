package com.natifedanilharitonov.hardskillsproject.data.repository

interface ResourcesRepository {
    fun getEmailLabel(): String
    fun getEmailErrorLabel(): String
    fun getPasswordLabel(): String
    fun getPasswordErrorLabel(): String
    fun getNicknameLabel(): String
    fun getNicknameErrorLabel(): String
}