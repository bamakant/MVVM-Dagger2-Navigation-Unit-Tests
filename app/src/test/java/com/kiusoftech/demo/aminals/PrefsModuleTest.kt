/*
 * ********************************************************
 *   Copyright (c) 2022  Kiusoftech
 *   Created by Bama Kant Kar on 01/01/22, 9:12 PM
 *   All rights reserved.
 *   Last modified 01/01/22, 9:12 PM
 * ********************************************************
 */

package com.kiusoftech.demo.aminals

import android.app.Application
import com.kiusoftech.demo.aminals.di.PrefsModule
import com.kiusoftech.demo.aminals.util.SharedPreferencesHelper

class PrefsModuleTest(private val mockPrefs: SharedPreferencesHelper) : PrefsModule() {
    override fun providesSharedPreferences(app: Application): SharedPreferencesHelper {
        return mockPrefs
    }
}
