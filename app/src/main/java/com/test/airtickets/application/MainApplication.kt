package com.test.airtickets.application

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.test.airtickets.di.appModule
import com.test.main.di.mainModule
import com.test.search.chooseCountry.di.chooseCountryModule
import com.test.search.seeAll.di.seeAllModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application(){

    private val cicerone = Cicerone.create()

    val router get() = cicerone.router

    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        startKoin {
            androidContext(this@MainApplication)
            modules(appModule, mainModule, chooseCountryModule, seeAllModule)
        }
    }

    companion object {
        internal lateinit var INSTANCE: MainApplication
            private set
    }

}