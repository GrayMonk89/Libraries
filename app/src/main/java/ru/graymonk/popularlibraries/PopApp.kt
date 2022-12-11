package ru.graymonk.popularlibraries

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class PopApp : Application() {

    companion object{
        lateinit var instance: PopApp
    }

    private val cicerone : Cicerone<Router> by lazy {Cicerone.create()}

    val navigatorHolder = cicerone.getNavigatorHolder()
    val router = cicerone.router

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}