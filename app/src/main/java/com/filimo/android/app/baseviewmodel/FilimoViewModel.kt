package com.filimo.android.app.baseviewmodel

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

open class FilimoViewModel(coroutineDispatcherProvider: CoroutineDispatcherProvider = coroutineDispatcherProvider()) :
    BaseViewModel(coroutineContexts = coroutineDispatcherProvider)

fun coroutineDispatcherProvider() = object : CoroutineDispatcherProvider {
    override fun bgDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }

    override fun ioDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    override fun uiDispatcher(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun immediateDispatcher(): CoroutineDispatcher {
        return Dispatchers.Main.immediate
    }
}
