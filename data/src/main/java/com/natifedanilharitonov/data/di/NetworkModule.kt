package com.natifedanilharitonov.data.di

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.natifedanilharitonov.data.network.anime_image_source.AnimeRetrofitInstance
import com.natifedanilharitonov.data.network.users.UsersRetrofitInstance
import com.natifedanilharitonov.domain.Utils
import com.natifedanilharitonov.domain.Utils.ANIME_API
import com.natifedanilharitonov.domain.Utils.USERS_API
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val networkModule = module {
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
            .baseUrl(Utils.ANIME_IMAGE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single(named(USERS_API)) {
        Retrofit.Builder()
            .baseUrl(Utils.USERS_API_URL)
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