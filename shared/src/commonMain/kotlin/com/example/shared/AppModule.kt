package com.example.shared

import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single<Api>{
        ApiImplementation(
            get()
        )
    }.bind<Api>()

    single<LoginRepo> {
        LoginRepoImplementation(
            api = get()
        )
    }.bind<LoginRepo>()
}