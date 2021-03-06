package com.example.simpleretrofit2.api

import com.example.simpleretrofit2.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPost(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId: Int = 1,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>
}