package ru.graymonk.popularlibraries.converter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class ConverterPresenter(private val router: Router) : MvpPresenter<ConverterView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}