package com.example.mvvmtest

import android.app.Application
import com.example.mvvmtest.koin.myDiModule
import org.koin.android.ext.android.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(applicationContext, myDiModule)
    }
}