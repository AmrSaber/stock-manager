package com.example.stockmanager.common

import android.content.Context
import android.content.res.Configuration
import java.util.*

object Utils {
    fun getUniqueId(prefix: String) = "$prefix-${System.currentTimeMillis()}"

    object Locale {
        private const val LANGUAGE_KEY = "@keys:language"
        var languageCode: String = "ar"
//            get() = Paper.book().read(LANGUAGE_KEY, "ar")
//            set(value) {
//                Paper.book().write(LANGUAGE_KEY, value)
//            }

        fun getLocalizedContext(context: Context): Context {
            val locale = Locale(languageCode)
            java.util.Locale.setDefault(locale)

            val res = context.resources
            val config = Configuration(res.configuration)

            config.setLocale(locale)

            return context.createConfigurationContext(config)
        }
    }
}