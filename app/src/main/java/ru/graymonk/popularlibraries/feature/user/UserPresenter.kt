package ru.graymonk.popularlibraries.feature.user

import android.annotation.SuppressLint
import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.graymonk.popularlibraries.core.navigation.Screens
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.repository.IGithubRepository

class UserPresenter(private val repository: IGithubRepository, private val router: Router) :
    MvpPresenter<UserView>() {

    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        repository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.initList(it)
                    viewState.hideLoading()
                },
                {
                    Log.e("USER_LIST", it.message ?: "!!!")
                }
            )
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun showDetails(githubUser: GithubUser?) {
        val login = githubUser ?: GithubUser(0,"empty","")
        router.navigateTo(Screens.UserDetailsScreen(login))
    }

    fun showImageConverter() {
        router.navigateTo(Screens.ImageConverterScreen())
    }
}