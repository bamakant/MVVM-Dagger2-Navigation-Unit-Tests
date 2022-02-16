/*
 * ********************************************************
 *   Copyright (c) 2021  Kiusoftech
 *   Created by Bama Kant Kar on 26/12/21, 8:44 PM
 *   All rights reserved.
 *   Last modified 26/12/21, 8:44 PM
 * ********************************************************
 */

package com.kiusoftech.demo.aminals.di

import com.kiusoftech.demo.aminals.model.AnimalApiService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: AnimalApiService)
}
