/*
 * ********************************************************
 *   Copyright (c) 2021  Kiusoftech
 *   Created by Bama Kant Kar on 26/12/21, 9:29 PM
 *   All rights reserved.
 *   Last modified 26/12/21, 9:29 PM
 * ********************************************************
 */

package com.kiusoftech.demo.aminals.di

import com.kiusoftech.demo.aminals.viewmodel.AnimalViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, PrefsModule::class, AppModule::class])
interface ViewModelComponent {

    fun inject(viewModel: AnimalViewModel)
}
