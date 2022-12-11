package ru.graymonk.popularlibraries

import moxy.MvpPresenter
import ru.graymonk.popularlibraries.utils.Constants

class CountersPresenter(private val model: CountersModel) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun onCounterOneClick() {
        viewState.setCounterOneText(model.next(Constants.DEFAULT_VALUE_ZERO).toString())
    }

    fun onCounterTwoClick() {
        viewState.setCounterTwoText(model.next(Constants.DEFAULT_VALUE_ONE).toString())
    }

    fun onCounterThirdClick() {
        viewState.setCounterThirdText(model.next(Constants.DEFAULT_VALUE_TWO).toString())
    }

}