package com.natifedanilharitonov.hardskillsproject.data.repository.random_images

class RandomAnimeImageRepositoryImpl(
    private val randomAnimeImageRepository: RandomAnimeImageRepository
) : RandomAnimeImageRepository {
    override suspend fun getImage(): String {
        return randomAnimeImageRepository.getImage()
    }
}