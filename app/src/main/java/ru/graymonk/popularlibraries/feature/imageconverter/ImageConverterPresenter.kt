package ru.graymonk.popularlibraries.feature.imageconverter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class ImageConverterPresenter(private val router: Router): MvpPresenter<ImageConverterView>(){
    fun onBackPressed(): Boolean{
        router.exit()
        return true
    }
}