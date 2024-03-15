package com.natifedanilharitonov.hardskillsproject.data.network.users

import com.natifedanilharitonov.hardskillsproject.data.network.users.model.NetworkUserResult
import com.natifedanilharitonov.hardskillsproject.domain.Utils.DEFAULT_USER_COUNT
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersRetrofitInstance {
    @GET("api/")
    suspend fun getUsers(@Query("results") results: String = DEFAULT_USER_COUNT): NetworkUserResult
}