package ru.graymonk.popularlibraries.feature.user.detail.repositorydetail

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.graymonk.popularlibraries.model.GithubRepository

class RepositoryDetailPresenter(private val githubRepository: GithubRepository, val router: Router): MvpPresenter<RepositoryDetailView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.show(githubRepository)
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}