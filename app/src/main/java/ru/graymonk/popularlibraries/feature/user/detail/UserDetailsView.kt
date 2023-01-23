package ru.graymonk.popularlibraries.feature.user.detail

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.graymonk.popularlibraries.model.GithubRepository
import ru.graymonk.popularlibraries.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserDetailsView: MvpView{
    fun show(user: GithubUser, repository : List<GithubRepository>)
    fun showLoading()
    fun hideLoading()
}