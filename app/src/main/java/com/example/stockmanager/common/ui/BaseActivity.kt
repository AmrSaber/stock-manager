package com.example.stockmanager.common.ui

import android.app.Activity
import android.os.Bundle

abstract class BaseActivity(private val layoutId: Int) : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(layoutId)
    }
}