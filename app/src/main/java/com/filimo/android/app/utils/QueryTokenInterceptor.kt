package com.filimo.android.app.utils

import okhttp3.Interceptor
import okhttp3.Response

class QueryTokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder().build()

        val requestBuilder = original.newBuilder()
                .url(url)
        requestBuilder.addHeader("jsonType", "simple")

        val request = requestBuilder.build()
        return chain.proceed(request)
    }


}