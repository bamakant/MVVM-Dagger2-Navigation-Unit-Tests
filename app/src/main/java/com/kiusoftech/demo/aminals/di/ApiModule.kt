/*
 * ********************************************************
 *   Copyright (c) 2021  Kiusoftech
 *   Created by Bama Kant Kar on 26/12/21, 8:38 PM
 *   All rights reserved.
 *   Last modified 26/12/21, 8:38 PM
 * ********************************************************
 */

package com.kiusoftech.demo.aminals.di

import com.kiusoftech.demo.aminals.model.AnimalApi
import com.kiusoftech.demo.aminals.model.AnimalApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
open class ApiModule {

    private val BASE_URL = "https://us-central1-apis-4674e.cloudfunctions.net/"

    @Provides
    fun provideAnimalApi(): AnimalApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(AnimalApi::class.java)
    }

    @Provides
    open fun providesAnimalApiServices() : AnimalApiService{
        return AnimalApiService()
    }
}
