package com.filimo.android.data.searchMovies

import com.filimo.android.data.entity.MovieDto
import com.filimo.android.data.entity.SearchMoviesDto
import com.filimo.android.data.entity.mapToMovies
import com.filimo.android.domain.model.Failure
import com.filimo.android.domain.model.Movie
import com.filimo.android.domain.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException

class SearchMoviesRemoteDataSource(private val searchMoviesApi: SearchMoviesApi,
                                   private val dispatcher: CoroutineDispatcher) {

     suspend fun searchMovies(query: String): Result<List<Movie>> {
         println("zozo: " + query)
            return when (val response = processCall(dispatcher) {
                searchMoviesApi.searchMovies(query) }) {
                 is SearchMoviesDto -> {
                     Result.Success(data = (response.data as List<MovieDto>).mapToMovies())
                 }
                 else -> {
                     Result.Error(message = (response as String))
                 }
             }
         }

    }

    private suspend fun processCall( dispatcher: CoroutineDispatcher, responseCall: suspend () -> Response<*>): Any? {

        return withContext(dispatcher) {
             try {
                val response = responseCall.invoke()
                 val responseCode = response.code()

                 when {
                     response.isSuccessful -> {
                         response.body()
                     }
                     response.message() != null -> {
                         Failure.ServerException.UnknownError().message

                     }
                     else -> {
                         "${response.message()} $responseCode"
                     }
                 }
            } catch (e: IOException) {

                 Failure.GeneralException.ConnectionError().message

             }
        }

}