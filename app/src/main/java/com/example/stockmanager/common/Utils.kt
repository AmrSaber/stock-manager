package com.example.stockmanager.common

object Utils {
    fun getUniqueId(prefix: String) = "$prefix-${System.currentTimeMillis()}"
}