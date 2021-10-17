package com.simdamsi.trehigo.network

import com.simdamsi.trehigo.models.PostResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    // ----------------------------------------------------------------
    // Posts
    // ----------------------------------------------------------------

    @GET("v1/posts")
    suspend fun getPosts(): Response<PostResponse>

    @GET("v1/posts")
    suspend fun getPostsPaged(@Query("page") page: Int): Response<PostResponse>
}