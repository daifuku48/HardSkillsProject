package com.natifedanilharitonov.hardskillsproject.di

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source.AnimeRetrofitInstance
import com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source.model.AnimeImageNetwork
import com.natifedanilharitonov.hardskillsproject.domain.Utils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Firebase.auth
    }

    factory {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(Utils.ANIME_IMAGE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<AnimeRetrofitInstance> {
        get<Retrofit>().create(AnimeRetrofitInstance::class.java)
    }
}