package com.filimo.android.app.searchMovies.presenter.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.filimo.android.app.R
import com.filimo.android.app.searchMovies.presenter.MoviesViewModel
import com.filimo.android.domain.model.Result
import org.koin.androidx.compose.getViewModel
import java.lang.reflect.Modifier
@Composable
fun SearchMoviesPage(modifier: Modifier = Modifier()) {

    val viewModel = getViewModel<MoviesViewModel>()
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    when (val it = viewModel.moviesLiveData.observeAsState().value){

        is Result.Initial -> {
            Column {
                SearchView(textState)
                EmptyView(message = stringResource(id = R.string.search_movie))
            }
        }

        is Result.Error -> {
            val message = it.message
            Toast.makeText(LocalContext.current, message, Toast.LENGTH_SHORT).show()

        }
        is Result.Loading -> {
            Column {

                SearchView(textState)
                Progress()
            }
        }
        is Result.Success -> {
            if(it.data.isEmpty()){
                Column {
                    SearchView(textState)
                    EmptyView(message = stringResource(id = R.string.empty_result))
                }
            }else{
                Column {
                    SearchView(textState)
                    MoviesList(
                        list = it.data
                    )
                }
            }

        }
    }

    Column {
        SearchView(textState)
    }

}