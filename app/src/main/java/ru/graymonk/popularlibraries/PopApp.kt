package ru.graymonk.popularlibraries

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import ru.graymonk.popularlibraries.core.database.GithubAppDataBase
import ru.graymonk.popularlibraries.core.utils.ConnectivityListener


class PopApp : Application() {

    companion object {
        lateinit var instance: PopApp
    }

    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }

    val navigatorHolder = cicerone.getNavigatorHolder()
    val router = cicerone.router

    val dataBase: GithubAppDataBase by lazy {
        GithubAppDataBase.create(this)
    }

    private lateinit var connectivityListener: ConnectivityListener

    override fun onCreate() {
        super.onCreate()
        instance = this

        connectivityListener =
            ConnectivityListener(applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)

        RxJavaPlugins.setErrorHandler {
        }
    }

    fun getConnectiveObservable() = connectivityListener.status()
    fun getConnectiveObservableSingle() = connectivityListener.statusSingle()
}