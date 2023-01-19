package ru.graymonk.popularlibraries.user.detail

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.graymonk.popularlibraries.repository.GithubRepository
import ru.graymonk.popularlibraries.utils.disposeBy
import ru.graymonk.popularlibraries.utils.subscribeByDefault

class UserDetailsPresenter(
    private val repository: GithubRepository,
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
        repository.getUserByLogin(login)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.show(it)
                    viewState.hideLoading()
                },
                {}
            ).disposeBy(bag)
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}