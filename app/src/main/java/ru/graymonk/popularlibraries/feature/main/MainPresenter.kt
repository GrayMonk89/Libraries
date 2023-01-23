package ru.graymonk.popularlibraries.feature.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.graymonk.popularlibraries.core.navigation.Screens


class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.UserScreen)
    }

    fun onBackPressed() {
        router.exit()
    }


}