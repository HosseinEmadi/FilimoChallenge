package com.filimo.android.app.searchMovies.presenter.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.filimo.android.app.R

@Composable
fun EmptyView(modifier: Modifier = Modifier, message: String) {

    Column( modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(50.dp))

        val image: Painter = painterResource(id = R.drawable.ic_empty_list)
        Image(
            modifier = Modifier.size(120.dp),
            painter = image,
            contentDescription = "")

        Text(
            text = message,
            modifier = Modifier.padding(all = 4.dp),
            color = Color.Black,
            style = MaterialTheme.typography.body1,
        )
    }

}