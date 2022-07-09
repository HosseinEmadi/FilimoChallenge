package com.filimo.android.data.entity

import com.filimo.android.domain.model.Movie
import com.filimo.android.domain.model.Pic


fun List<MovieDto>.mapToMovies() = map { movieDto ->
    Movie(movieDto.movie_title, movieDto.movie_title_en, movieDto.pic.mapToPic())
}

fun PicDto.mapToPic() = Pic(movie_img_s, movie_img_m, movie_img_b)
