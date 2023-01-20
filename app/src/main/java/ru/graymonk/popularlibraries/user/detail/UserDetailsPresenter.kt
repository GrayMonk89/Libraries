package ru.graymonk.popularlibraries.user.detail

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.graymonk.popularlibraries.model.GithubRepository
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.repository.IGithubRepository
import ru.graymonk.popularlibraries.utils.disposeBy
import ru.graymonk.popularlibraries.utils.subscribeByDefault

class UserDetailsPresenter(
    private val repository: IGithubRepository,
    private val router: Router
) : MvpPresenter<UserDetailsView>() {
//    override fun onFirstViewAttach() {
//        super.onFirstViewAttach()
//        viewState.showLoading()
//        repository.getUsers().observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                viewState.show(it)
//                viewState.hideLoading()
//            }, {})
//    }

    private val bag = CompositeDisposable()

    fun loadUser(login: String) {
        viewState.showLoading()
        Single.zip(
            repository.getUserByLogin(login),
            repository.getReposByLogin(login)
        ) { user, repos ->
            return@zip Pair<GithubUser, List<GithubRepository>>(user, repos)
        }
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.show(it.first, it.second)
                    viewState.hideLoading()
                },
                {}
            ).disposeBy(bag)
    }

    fun onRepositoryClicked(){}

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}