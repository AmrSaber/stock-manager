package com.example.stockmanager

import android.app.Application
import io.paperdb.Paper

@Suppress("unused")
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Paper.init(this)
    }
}