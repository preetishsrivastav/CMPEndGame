package com.example.shared

import com.example.shared.data.Api
import com.example.shared.data.LoginRepo
import com.example.shared.domain.ApiImplementation
import com.example.shared.domain.LoginRepoImplementation
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