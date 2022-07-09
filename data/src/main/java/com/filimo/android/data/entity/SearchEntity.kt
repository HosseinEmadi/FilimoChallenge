package com.filimo.android.data.entity


data class SearchMoviesDto(val data: List<MovieDto>?)


data class MovieDto(val movie_title: String,
                    val movie_title_en: String,
                    val pic: PicDto)

data class PicDto( val movie_img_s: String,
                   val movie_img_m: String,
                   val movie_img_b: String)