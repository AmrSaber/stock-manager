package com.example.stockmanager

import android.app.Application
import android.content.Context
import com.example.stockmanager.common.Utils
import io.paperdb.Paper

@Suppress("unused")
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Paper.init(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(Utils.Locale.getLocalizedContext(base!!))
    }
}