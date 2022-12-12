package ru.graymonk.popularlibraries.user.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.graymonk.popularlibraries.PopApp
import ru.graymonk.popularlibraries.core.OnBackPressedListener
import ru.graymonk.popularlibraries.databinding.FragmentUserDetailsBinding
import ru.graymonk.popularlibraries.model.GithubUser

class UserDetailsFragment : MvpAppCompatFragment(), OnBackPressedListener, UserDetailsView {

    private var _binding: FragmentUserDetailsBinding? = null
    private val binding: FragmentUserDetailsBinding
        get() = _binding!!

    private val presenter: UserDetailsPresenter by moxyPresenter {
        UserDetailsPresenter(PopApp.instance.router)
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

        renderUserDetail(arguments?.getParcelable<GithubUser>("test"))
    }

    private fun renderUserDetail(githubUser: GithubUser?) {
        githubUser?.let {
            binding.tvDetailsUserLogin.text = githubUser.login
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(gitHubUser: GithubUser) = UserDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable("test", gitHubUser)
            }
        }
    }

    override fun onBackPressed(): Boolean = presenter.onBackPressed()

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}