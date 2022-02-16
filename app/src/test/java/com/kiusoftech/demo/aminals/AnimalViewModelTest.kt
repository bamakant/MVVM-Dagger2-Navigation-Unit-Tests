/*
 * ********************************************************
 *   Copyright (c) 2021  Kiusoftech
 *   Created by Bama Kant Kar on 26/12/21, 10:13 PM
 *   All rights reserved.
 *   Last modified 26/12/21, 10:13 PM
 * ********************************************************
 */

package com.kiusoftech.demo.aminals

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kiusoftech.demo.aminals.di.AppModule
import com.kiusoftech.demo.aminals.di.DaggerViewModelComponent
import com.kiusoftech.demo.aminals.model.AnimalApiService
import com.kiusoftech.demo.aminals.util.SharedPreferencesHelper
import com.kiusoftech.demo.aminals.viewmodel.AnimalViewModel
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.Executor

class AnimalViewModelTest {
    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Mock
    lateinit var animalService: AnimalApiService

    @Mock
    lateinit var prefs: SharedPreferencesHelper

    val application = Mockito.mock(Application::class.java)

    val animalViewModel = AnimalViewModel(application)

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        val testComponent = DaggerViewModelComponent.builder()
            .appModule(AppModule((application)))
            .apiModule(ApiModuleTest(animalService))
            .prefsModule(PrefsModuleTest(prefs))
            .build()
            .inject(animalViewModel)
    }

    @Before
    fun setupRxSchedulers(){
        val immediate = object : Scheduler(){
            override fun createWorker(): Worker {
                return  ExecutorScheduler.ExecutorWorker(Executor { it.run() }, true)
            }
        }
        RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler -> immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> immediate }
    }
}
