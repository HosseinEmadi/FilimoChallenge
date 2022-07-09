package com.filimo.android.app.searchMovies.presenter.ui

import androidx.compose.foundation.layout.*

import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.filimo.android.app.R
import com.filimo.android.domain.model.Movie

@Composable
fun MovieCard(movie: Movie?,
              modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)) {
        Row(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {

            movie?.pic?.movie_img_s?.let {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(it)
                        .crossfade(true)
                        .build(),

                    contentScale = ContentScale.Crop,
                    contentDescription = "",
                    modifier = Modifier.size(dimensionResource(id = R.dimen.movie_item))
                )
            }

            Spacer(
                modifier = Modifier.width(8.dp)
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = movie?.movie_title ?: "",
                    modifier = Modifier.padding(all = 4.dp),
                    color = Color.Black,
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                movie?.movie_title_en?.let {
                    Text(
                        text = it ?: "",
                        modifier = Modifier.padding(all = 4.dp),
                        color = Color.Black,
                        style = MaterialTheme.typography.body1,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }

}