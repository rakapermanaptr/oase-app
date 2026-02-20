package com.rakapermanaptr.oase

import android.app.Application
import com.rakapermanaptr.oase.di.initKoin

class OaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        initKoin { }
    }

    companion object {
        lateinit var instance: OaseApplication
            private set
    }
}