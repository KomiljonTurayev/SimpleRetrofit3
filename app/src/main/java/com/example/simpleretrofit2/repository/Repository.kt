package com.example.simpleretrofit2.repository

import com.example.simpleretrofit2.api.RetrofitInstance
import com.example.simpleretrofit2.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost(number)
    }

    suspend fun getCustomPosts(userId: Int,sort:String,order:String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId,sort,order)
    }
}