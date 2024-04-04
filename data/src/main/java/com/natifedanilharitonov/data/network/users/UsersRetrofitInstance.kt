package com.natifedanilharitonov.data.network.users

import com.natifedanilharitonov.data.network.users.model.NetworkUserResult
import com.natifedanilharitonov.data.source.Utils.DEFAULT_USER_COUNT
import com.natifedanilharitonov.data.source.Utils.USER
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersRetrofitInstance {
    @GET("api/")
    suspend fun getUsers(@Query("results") results: String = DEFAULT_USER_COUNT): NetworkUserResult

    @GET("api/")
    suspend fun getUser(@Query("results") results: String = USER): NetworkUserResult
}