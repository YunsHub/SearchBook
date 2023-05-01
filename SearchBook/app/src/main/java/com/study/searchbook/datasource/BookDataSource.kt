package com.study.searchbook.datasource

import com.study.searchbook.api.BookApi
import com.study.searchbook.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookDataSource @Inject constructor(
    private val bookApi: BookApi
){
    fun getBooks(id: String, secret: String, title: String): Flow<Response<Book>> = flow {
        emit(bookApi.getBooks(id, secret, title))
    }
}