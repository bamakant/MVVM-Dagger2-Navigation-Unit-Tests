/*
 * ********************************************************
 *   Copyright (c) 2021  Kiusoftech
 *   Created by Bama Kant Kar on 06/09/21, 8:51 AM
 *   All rights reserved.
 *   Last modified 06/09/21, 8:50 AM
 * ********************************************************
 */

package com.kiusoftech.demo.aminals.util

import android.content.Context
import android.preference.PreferenceManager

class SharedPreferencesHelper(context: Context) {

    private val PREF_API_KEY = "Api key"

    private val prefs = PreferenceManager.getDefaultSharedPreferences(context.applicationContext)

    fun saveApiKey(key: String?) {
        prefs.edit().putString(PREF_API_KEY, key).apply()
    }

    fun getApiKey() = prefs.getString(PREF_API_KEY, null)

}