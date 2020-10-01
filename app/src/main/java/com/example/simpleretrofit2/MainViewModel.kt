package com.example.simpleretrofit2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleretrofit2.repository.Repository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.simpleretrofit2.model.Post
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost(number: Int) {
        viewModelScope.launch {
            val response = repository.getPost(number)
            myResponse.value = response
        }
    }

    fun getCustomPosts(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId, sort, order)
            myCustomPosts.value = response
        }
    }
}