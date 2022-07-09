package com.filimo.android.app.searchMovies.di

import com.filimo.android.app.baseviewmodel.coroutineDispatcherProvider
import com.filimo.android.app.searchMovies.presenter.MoviesViewModel
import com.filimo.android.data.searchMovies.SearchMoviesApi
import com.filimo.android.data.searchMovies.SearchMoviesRemoteDataSource
import com.filimo.android.data.searchMovies.SearchMoviesRepositoryImp
import com.filimo.android.di.AUTHENTICATED_RETROFIT
import com.filimo.android.di.createNetwork
import com.filimo.android.domain.intractor.SearchMoviesUseCase
import com.filimo.android.domain.repository.SearchMovieRepository
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named


val searchMoviesModule = module {

    single { createNetwork(SearchMoviesApi::class.java,get(named(AUTHENTICATED_RETROFIT))) }

    single { SearchMoviesUseCase(get()) }
    single { SearchMoviesRemoteDataSource(get(), coroutineDispatcherProvider().ioDispatcher()) }

    single<SearchMovieRepository> { SearchMoviesRepositoryImp(get()) }

    viewModel {

        MoviesViewModel(coroutineDispatcherProvider(), get())
    }
}