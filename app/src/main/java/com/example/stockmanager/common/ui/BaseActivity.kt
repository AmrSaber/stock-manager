package com.example.stockmanager.common.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

abstract class BaseActivity(private val layoutId: Int) : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(layoutId)
    }
}