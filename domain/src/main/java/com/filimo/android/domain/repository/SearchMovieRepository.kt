package com.filimo.android.domain.repository

import com.filimo.android.domain.model.Movie
import com.filimo.android.domain.model.Result


interface SearchMovieRepository{
    suspend fun searchMovies(query: String): Result<List<Movie>>
}