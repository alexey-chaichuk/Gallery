package com.example.gallery.di

import com.example.gallery.core.PicsUrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ConfigsModule {

    @Provides
    fun providePicsUrlProvider() : PicsUrlProvider = PicsUrlProvider(
        baseUrl = "https://picsum.photos/",
    )
}