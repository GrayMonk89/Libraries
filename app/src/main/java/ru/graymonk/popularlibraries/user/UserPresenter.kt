package ru.graymonk.popularlibraries.user

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import ru.graymonk.popularlibraries.core.navigation.UserDetailsScreen
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.repository.GithubRepository

class UserPresenter(private val repository: GithubRepository, private val router: Router) :
    MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        repository.getUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.initList(it)
                    viewState.hideLoading()
                },
                {}
            )
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun showDetails(githubUser: GithubUser?){
        val login = githubUser ?: GithubUser("empty")
        router.navigateTo(UserDetailsScreen(login))
    }
}