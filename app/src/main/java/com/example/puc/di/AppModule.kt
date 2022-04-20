package com.example.puc.di

import com.contentful.java.cda.CDAClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun contentClient() : CDAClient = CDAClient.builder()
        .setSpace("8k4vsqea01z5")
        .setToken("ntTX3V0m1T9acGRiZ-M0_-eIu2ME9YlkBeGJqJrOkUY")
        .build()

    @Provides
    fun gson() : Gson = GsonBuilder().setPrettyPrinting().create()

}