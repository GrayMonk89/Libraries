package ru.graymonk.popularlibraries.feature.user.detail

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.graymonk.popularlibraries.core.navigation.Screens
import ru.graymonk.popularlibraries.model.GithubRepository
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.repository.IGithubRepository
import ru.graymonk.popularlibraries.core.utils.disposeBy
import ru.graymonk.popularlibraries.core.utils.subscribeByDefault

class UserDetailsPresenter(
    private val repository: IGithubRepository,
    private val router: Router
) : MvpPresenter<UserDetailsView>() {
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

    fun onRepositoryClicked(githubRepository: GithubRepository){
        router.navigateTo(Screens.RepositoryDetailScreen(githubRepository))
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}