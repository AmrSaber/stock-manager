package com.example.stockmanager.common.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.stockmanager.common.Utils

abstract class BaseActivity(private val layoutId: Int) : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(layoutId)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(Utils.Locale.getLocalizedContext(newBase!!))
    }
}