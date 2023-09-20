package com.eval.simplesales

import android.app.Application
import com.eval.simplesales.utils.simpleSalesModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(simpleSalesModules)
        }
    }

    companion object {
        val appName = "com.eval.simplesales"
        lateinit var instance: App
    }

    init {
        instance = this
    }
}