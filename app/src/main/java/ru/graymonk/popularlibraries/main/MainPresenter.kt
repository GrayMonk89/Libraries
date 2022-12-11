package ru.graymonk.popularlibraries.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.graymonk.popularlibraries.core.navigation.UserScreen

class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.navigateTo(UserScreen)
    }

    fun onBackPressed() {
        router.exit()
    }


}