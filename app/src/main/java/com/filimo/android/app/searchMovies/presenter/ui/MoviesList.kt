package com.filimo.android.app.searchMovies.presenter.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.filimo.android.domain.model.Movie


@Composable
fun MoviesList(
    modifier: Modifier = Modifier,
    list: List<Movie>
) {
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = modifier.padding(10.dp),
        state = listState
    ){
        items(list){ item ->
            MovieCard(
                item)
        }
    }
}

