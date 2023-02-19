package com.larix.katyakitka

import android.app.Application

class MyApp: Application() {
    companion object {
        lateinit var asf: SharedPreferencesManager
    }
    override fun onCreate() {
        super.onCreate()
        asf= SharedPreferencesManager(this)
    }
}