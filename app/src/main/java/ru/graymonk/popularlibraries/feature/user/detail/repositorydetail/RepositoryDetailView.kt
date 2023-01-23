package ru.graymonk.popularlibraries.feature.user.detail.repositorydetail

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.graymonk.popularlibraries.model.GithubRepository


@StateStrategyType(AddToEndSingleStrategy::class)
interface RepositoryDetailView : MvpView {

    fun show(githubRepository: GithubRepository)
}