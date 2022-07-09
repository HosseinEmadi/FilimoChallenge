package com.filimo.android.domain.intractor

import com.filimo.android.domain.model.Movie
import com.filimo.android.domain.model.Result
import com.filimo.android.domain.repository.SearchMovieRepository


class SearchMoviesUseCase(private val searchMovieRepository: SearchMovieRepository) {

    suspend fun execute(query: String): Result<List<Movie>> {
         return searchMovieRepository.searchMovies(query)
    }
}