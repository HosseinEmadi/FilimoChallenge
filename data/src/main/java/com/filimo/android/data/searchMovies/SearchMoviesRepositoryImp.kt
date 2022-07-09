package com.filimo.android.data.searchMovies

import com.filimo.android.domain.model.Movie
import com.filimo.android.domain.model.Result
import com.filimo.android.domain.repository.SearchMovieRepository


class SearchMoviesRepositoryImp(private val searchMoviesRemoteDataSource: SearchMoviesRemoteDataSource):
    SearchMovieRepository {

     override suspend fun searchMovies(query: String): Result<List<Movie>> {

        return searchMoviesRemoteDataSource.searchMovies(query)

    }
}
