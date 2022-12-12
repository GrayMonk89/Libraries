package ru.graymonk.popularlibraries.user.detail

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserDetailsPresenter(private val router: Router): MvpPresenter<UserDetailsView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun onBackPressed(): Boolean{
        router.exit()
        return true
    }
}