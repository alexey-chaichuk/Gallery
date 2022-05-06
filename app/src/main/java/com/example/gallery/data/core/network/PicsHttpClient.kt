package com.example.gallery.data.core.network

import com.example.gallery.core.PicsUrlProvider
import com.example.gallery.data.remote.api.PicsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

interface PicsHttpClient {
    val picsApi : PicsApi
}

class PicsHttpClientImpl @Inject constructor(
    picsUrlProvider: PicsUrlProvider,
) : PicsHttpClient {

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(picsUrlProvider.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override val picsApi: PicsApi by lazy(LazyThreadSafetyMode.NONE) { retrofit.create(PicsApi::class.java) }
}