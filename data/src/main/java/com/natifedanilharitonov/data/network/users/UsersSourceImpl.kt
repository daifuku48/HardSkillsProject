package com.natifedanilharitonov.data.network.users

import android.util.Log
import com.natifedanilharitonov.data.network.image_downloader.ImageDownloaderSource
import com.natifedanilharitonov.data.network.users.model.NetworkUserBitmap
import com.natifedanilharitonov.data.network.users.model.toUserWithBitmap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

internal class UsersSourceImpl(
    private val instance: UsersRetrofitInstance,
    private val downloaderSource: ImageDownloaderSource
) : UsersSource {
    override suspend fun getUsers(): List<NetworkUserBitmap> {

        val users = instance.getUsers().users
        Log.d("AAA", "image")
        val usersList = ArrayList<NetworkUserBitmap>()
        val deferredImages =
            users.map {
                CoroutineScope(Dispatchers.IO).async {
                    Log.d("AAA", "image")
                    downloaderSource.loadImage(it.picture.medium)
                }
            }
        for ((count, deferred) in deferredImages.withIndex()) {
            usersList.add(users[count].toUserWithBitmap(deferred.await()))
        }
        return usersList

    }

    override suspend fun getUser(): NetworkUserBitmap? {
        return try {
            val user = instance.getUser()
            val image = downloaderSource.loadImage(user.users.first().picture.medium)
            user.users.first().toUserWithBitmap(image)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}