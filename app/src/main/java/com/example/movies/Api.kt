package com.example.movies

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    @GET("movie/top_rated")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "ff442d6526ef8a5a1b12598a717a67c0",
        @Query("page") page: Int
    ): Call<MovieResponse>
}
