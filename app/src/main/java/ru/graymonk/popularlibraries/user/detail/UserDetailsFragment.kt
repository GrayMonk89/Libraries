package ru.graymonk.popularlibraries.user.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.graymonk.popularlibraries.PopApp
import ru.graymonk.popularlibraries.core.OnBackPressedListener
import ru.graymonk.popularlibraries.databinding.FragmentUserDetailsBinding
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.network.NetworkProvider
import ru.graymonk.popularlibraries.repository.implementation.GithubRepositoryImpl
import ru.graymonk.popularlibraries.utils.Constants
import ru.graymonk.popularlibraries.utils.makeGone
import ru.graymonk.popularlibraries.utils.makeVisible

class UserDetailsFragment : MvpAppCompatFragment(), OnBackPressedListener, UserDetailsView {

    private var _binding: FragmentUserDetailsBinding? = null
    private val binding: FragmentUserDetailsBinding
        get() = _binding!!

    private val presenter: UserDetailsPresenter by moxyPresenter {
        UserDetailsPresenter(GithubRepositoryImpl(NetworkProvider.usersApi),  PopApp.instance.router)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(Constants.CONST_ARGUMENT_LOGIN)?.let {
            presenter.loadUser(it)
        }

    }


    companion object {
        @JvmStatic
        fun newInstance(gitHubUser: GithubUser) = UserDetailsFragment().apply {
            arguments = Bundle().apply {
                putString(Constants.CONST_ARGUMENT_LOGIN, gitHubUser.login)
            }
        }
    }

    override fun onBackPressed(): Boolean = presenter.onBackPressed()

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun show(user: GithubUser) {
        user.let {
            binding.textViewDetailsUserLogin.text = user.login
            binding.imageViewDetailsUserAvatar.load(user.avatarUrl)
            binding.textViewDetailsUserId.text = user.id.toString()
        }
    }

    override fun showLoading() {
        with(binding)
        {
            imageViewDetailsUserAvatar.makeGone()
            textViewDetailsUserId.makeGone()
            textViewDetailsUserLogin.makeGone()
            progressBar.makeVisible()
        }

    }

    override fun hideLoading() {
        with(binding)
        {
            imageViewDetailsUserAvatar.makeVisible()
            textViewDetailsUserId.makeVisible()
            textViewDetailsUserLogin.makeVisible()
            progressBar.makeGone()
        }
    }

}