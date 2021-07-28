package com.example.weatherapp.services

import com.example.weatherapp.data.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {
    companion object{
        const val BASE_URL ="https://www.conakryplanete.info/"
    }

    @GET("wp/v2/posts")
    suspend fun getPosts(
        @Query("page") page: Int,
        @Query("categories") categorie: Int
    ):List<Post>
}