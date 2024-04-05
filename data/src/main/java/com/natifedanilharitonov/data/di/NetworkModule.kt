package com.natifedanilharitonov.data.di

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.natifedanilharitonov.data.network.animeImageSource.AnimeRetrofitInstance
import com.natifedanilharitonov.data.network.users.UsersRetrofitInstance
import com.natifedanilharitonov.data.source.Utils.ANIME_API
import com.natifedanilharitonov.data.source.Utils.ANIME_IMAGE_URL
import com.natifedanilharitonov.data.source.Utils.USERS_API
import com.natifedanilharitonov.data.source.Utils.USERS_API_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val networkModule =
    module {
        single {
            Firebase.auth
        }

        factory {
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor())
                .build()
        }

        single(named(ANIME_API)) {
            Retrofit.Builder()
                .baseUrl(ANIME_IMAGE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        single(named(USERS_API)) {
            Retrofit.Builder()
                .baseUrl(USERS_API_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        single<AnimeRetrofitInstance> {
            get<Retrofit>(named(ANIME_API)).create()
        }

        single<UsersRetrofitInstance> {
            get<Retrofit>(named(USERS_API)).create()
        }
    }
