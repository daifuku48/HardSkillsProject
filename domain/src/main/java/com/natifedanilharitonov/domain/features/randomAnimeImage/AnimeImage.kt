package com.natifedanilharitonov.domain.features.randomAnimeImage

import android.graphics.Bitmap

interface AnimeImage {
    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun mapImagePending(): T

        fun mapImageAccess(image: Bitmap): T

        fun mapImageError(): T
    }

    data object ImagePending : AnimeImage {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapImagePending()
        }
    }

    data class ImageAccess(val image: Bitmap) : AnimeImage {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapImageAccess(image)
        }
    }

    data object ImageError : AnimeImage {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapImageError()
        }
    }
}
