package com.filimo.android.di

import com.filimo.android.app.utils.QueryTokenInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val AUTHENTICATED_CLIENT = "AUTHENTICATED_CLIENT"
const val AUTHENTICATED_RETROFIT = "AUTHENTICATED_RETROFIT"
const val AUTHENTICATED_INTERCEPTOR = "AUTHENTICATED_INTERCEPTOR"

// base network constants names  that provided by app module
const val APP_BASE_URL = "APP_BASE_URL"
const val APP_NETWORK_TIMEOUT = "APP_NETWORK_TIMEOUT"

@JvmField
val networkModule = module {

    single { provideGson() }

    //authenticated client
    single(named(AUTHENTICATED_CLIENT)) { provideAuthenticatedOkhttpClient(get(named(APP_NETWORK_TIMEOUT))) }
    single(named(AUTHENTICATED_RETROFIT)) { provideRetrofitModule(get(named(AUTHENTICATED_CLIENT)),get(),get(named(APP_BASE_URL))) }


}


inline fun <reified T> createNetwork(service: Class<T>, retrofit: Retrofit): T = retrofit.create(T::class.java)


fun provideAuthenticatedOkhttpClient(timeout: Long): OkHttpClient {

    val builder = OkHttpClient.Builder()
    builder.addInterceptor(QueryTokenInterceptor())
        .readTimeout(timeout, TimeUnit.MILLISECONDS)
        .writeTimeout(timeout, TimeUnit.MILLISECONDS)
        .connectTimeout(timeout, TimeUnit.MILLISECONDS)

    if (BuildConfig.DEBUG){
        val i = HttpLoggingInterceptor()
        i.setLevel(HttpLoggingInterceptor.Level.BASIC)
        //cast as Any for release mode
        builder.addNetworkInterceptor(i as Any as Interceptor)
    }

    return builder.build()
}



fun provideRetrofitModule(client: OkHttpClient, gosn: Gson,baseUrl: String): Retrofit {
    return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gosn))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
}



fun provideGson(): Gson {
    return GsonBuilder().serializeNulls()
            .create()
}

