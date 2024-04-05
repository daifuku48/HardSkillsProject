package com.natifedanilharitonov.domain.features.userList

interface UserPaginationResult {
    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun mapPaging(): T

        fun mapIdle(): T
    }

    data object Paging : UserPaginationResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapPaging()
        }
    }

    data object Idle : UserPaginationResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapIdle()
        }
    }
}
