package com.natifedanilharitonov.data.network.users.model

import com.google.gson.annotations.SerializedName

data class NetworkUserResult(
    @SerializedName("results")
    val users: List<NetworkUser>
)