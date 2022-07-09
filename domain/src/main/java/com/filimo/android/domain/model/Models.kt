package com.filimo.android.domain.model


data class SearchMovies(val data: List<Movie>?)



data class Movie(val movie_title: String?,
                 val movie_title_en: String?,
                 val pic: Pic?)

data class Pic(val movie_img_s: String?,
               val movie_img_m: String?,
               val movie_img_b: String?)

sealed class Failure {

    abstract class ServerException: Failure()  {

        data class UnknownError(val message: String = "Unknown Error") : GeneralException()

    }
    abstract class GeneralException: Failure()  {

        data class UnknownError(val message: String = "Unknown Error") : GeneralException()
        data class ConnectionError(val message: String = "Connection Error") : GeneralException()

    }
    abstract class SearchMovieException: Failure()  {

        data class AccessDenied(val message: String = "Upgrade to premium for use this feature") : SearchMovieException()


    }
}

