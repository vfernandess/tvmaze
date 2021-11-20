package com.voidx.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    factory(named("base_url")) {
        "https://api.tvmaze.com/"
    }

    single {
        val builder = OkHttpClient().newBuilder()

        builder.addInterceptor(
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                .setLevel(HttpLoggingInterceptor.Level.BASIC)
        )

        builder.build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(get(named("base_url")) as String)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}