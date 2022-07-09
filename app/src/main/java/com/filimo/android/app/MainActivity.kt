package com.filimo.android.app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import com.filimo.android.app.searchMovies.presenter.ui.SearchMoviesPage
import com.filimo.android.app.ui.theme.FilimoChallengeTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setMainView()
    }

    private fun setMainView() {
        setContent {
            FilimoChallengeTheme {
                window?.statusBarColor = MaterialTheme.colors.primaryVariant.hashCode()

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.primaryVariant),
                ) {
                    SearchMoviesPage()
                }
            }
        }
    }

}
