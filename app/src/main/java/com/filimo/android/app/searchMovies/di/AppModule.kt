package com.filimo.android.di

import org.koin.core.qualifier.named
import org.koin.dsl.module

const val APP_BASE_URL_ADDRESS = "https://www.filimo.com/"
const val APP_NETWORK_TIMEOUT_VALUE = 10000L // 10s


val appModule = module {

    single(named(APP_BASE_URL)) { APP_BASE_URL_ADDRESS }
    single(named(APP_NETWORK_TIMEOUT)) { APP_NETWORK_TIMEOUT_VALUE }

}
