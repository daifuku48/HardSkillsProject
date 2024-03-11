package com.natifedanilharitonov.hardskillsproject.di

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import org.koin.dsl.module

val networkModule = module {
    single {
        Firebase.auth
    }
}