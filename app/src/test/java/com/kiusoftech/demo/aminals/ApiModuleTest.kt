/*
 * ********************************************************
 *   Copyright (c) 2022  Kiusoftech
 *   Created by Bama Kant Kar on 01/01/22, 9:14 PM
 *   All rights reserved.
 *   Last modified 01/01/22, 9:14 PM
 * ********************************************************
 */

package com.kiusoftech.demo.aminals

import com.kiusoftech.demo.aminals.di.ApiModule
import com.kiusoftech.demo.aminals.model.AnimalApiService

class ApiModuleTest(private val mockApiService: AnimalApiService) : ApiModule() {
    override fun providesAnimalApiServices(): AnimalApiService {
        return mockApiService
    }
}
