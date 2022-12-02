package ru.graymonk.popularlibraries

import ru.graymonk.popularlibraries.utils.Constants

class CountersPresenter(private val view: MainView, private val model: CountersModel) {


    fun onCounterClick(id: Int) {
        when (id) {
            Constants.DEFAULT_VALUE_ZERO -> {
                view.setText(
                    Constants.DEFAULT_VALUE_ZERO,
                    model.next(Constants.DEFAULT_VALUE_ZERO).toString()
                )
            }
            Constants.DEFAULT_VALUE_ONE -> {
                view.setText(
                    Constants.DEFAULT_VALUE_ONE,
                    model.next(Constants.DEFAULT_VALUE_ONE).toString()
                )
            }
            Constants.DEFAULT_VALUE_TWO -> {
                view.setText(
                    Constants.DEFAULT_VALUE_TWO,
                    model.next(Constants.DEFAULT_VALUE_TWO).toString()
                )
            }
        }
    }
}