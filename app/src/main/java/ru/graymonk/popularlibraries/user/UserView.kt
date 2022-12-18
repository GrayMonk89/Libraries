package ru.graymonk.popularlibraries.user

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.graymonk.popularlibraries.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : MvpView {
    fun initList(list: List<GithubUser>)
    fun showLoading()
    fun hideLoading()
}