package ru.graymonk.popularlibraries.core.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.user.UserFragment
import ru.graymonk.popularlibraries.user.detail.UserDetailsFragment

object UserScreen: FragmentScreen{
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}

class UserDetailsScreen(private val gitHubUser: GithubUser) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserDetailsFragment.newInstance(gitHubUser)
    }
}