package com.study.searchbook.repository

import com.study.searchbook.datasource.BookDataSource
import com.study.searchbook.model.Book
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton
import com.study.searchbook.utils.Result
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import retrofit2.Response

@Singleton
class BookRepository @Inject constructor(
    private val bookDataSource: BookDataSource
){
    fun getBooks(id: String, secret: String, title: String): Flow<Result<Response<Book>>> = flow {
        emit(Result.Loading)
        bookDataSource.getBooks(id, secret, title).collect {
            emit(Result.Success(it))
        }
    }.catch { e ->
        emit(Result.Error(e))
    }
}