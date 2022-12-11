package ru.graymonk.popularlibraries

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.graymonk.popularlibraries.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun initList(list: List<GithubUser>)

    //fun updateList(list: List<GitHubUser>)
}