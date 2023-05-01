package com.study.searchbook.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.searchbook.model.Book
import com.study.searchbook.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.study.searchbook.utils.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Response

private const val TAG = "BookViewModel"

@HiltViewModel
class BookViewModel @Inject constructor(
    private val bookRepository: BookRepository
): ViewModel() {

    private val _book: MutableStateFlow<Result<Response<Book>>> =
        MutableStateFlow(Result.Unintialized)
    val book get() = _book.asStateFlow()

    fun getBooks(id: String, secret: String, title: String) {
        viewModelScope.launch(Dispatchers.IO){
            bookRepository.getBooks(id, secret, title).collectLatest {
                if(it is Result.Success) {
                    _book.value = it
                    Log.d(TAG, "Success getBooks: ${it.data.body()}")
                } else if(it is Result.Error) {
                    Log.d(TAG, "Error getBooks: $it")
                }
            }
        }
    }
}