package ru.graymonk.popularlibraries

import moxy.MvpPresenter
import ru.graymonk.popularlibraries.repository.GithubRepository

class CountersPresenter(private val repository: GithubRepository) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }


}