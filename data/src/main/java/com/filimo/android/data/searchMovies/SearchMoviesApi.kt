package com.filimo.android.data.searchMovies

import com.filimo.android.data.entity.SearchMoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface SearchMoviesApi {

    @GET("api/en/v1/movie/movie/list/tagid/1000300/text/{query}/sug/on")
    suspend fun searchMovies(@Path("query") query: String): Response<SearchMoviesDto>

}