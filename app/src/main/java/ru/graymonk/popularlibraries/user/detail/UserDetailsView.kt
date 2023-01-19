package ru.graymonk.popularlibraries.user.detail

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.graymonk.popularlibraries.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserDetailsView: MvpView{
    fun show(user: GithubUser)
    fun showLoading()
    fun hideLoading()
}