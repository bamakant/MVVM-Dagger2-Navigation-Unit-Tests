/*
 * ********************************************************
 *   Copyright (c) 2021  Kiusoftech
 *   Created by Bama Kant Kar on 26/12/21, 9:50 PM
 *   All rights reserved.
 *   Last modified 26/12/21, 9:50 PM
 * ********************************************************
 */

package com.kiusoftech.demo.aminals.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {

    @Provides
    fun providesApp(): Application = app
}
