package com.study.searchbook.utils

import java.io.IOException

sealed class Result<out T> {
    object Unintialized : Result<Nothing>()

    object Loading : Result<Nothing>()

    object Empty : Result<Nothing>()

    data class Success<T>(val data: T) : Result<T>()

    data class Fail<T>(val data: T) : Result<T>()

    data class Error(val exception: Throwable) : Result<Nothing>() {
        val isNetworkError = exception is IOException
    }

}