package ru.graymonk.popularlibraries.feature.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.graymonk.popularlibraries.PopApp
import ru.graymonk.popularlibraries.core.OnBackPressedListener
import ru.graymonk.popularlibraries.databinding.FragmentUserListBinding
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.core.network.NetworkProvider
import ru.graymonk.popularlibraries.repository.implementation.GithubRepositoryImpl

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener, OnItemClickListener {
    companion object {
        fun getInstance(): UserFragment {
            return UserFragment()
        }
    }

    private var _binding: FragmentUserListBinding? = null
    private val binding: FragmentUserListBinding
        get() = _binding!!

    private val adapter = UserAdapter(this)

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(NetworkProvider.usersApi,PopApp.instance.dataBase.userDao(),PopApp.instance.getConnectiveObservableSingle()), PopApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        convertTo()
        setClickListener()
    }

    private fun setClickListener() {
        binding.fabImageConverter.setOnClickListener { }
    }

    private fun initAdapter() {
        with(binding) {
            recyclerViewGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewGithubUsers.adapter = adapter
        }
    }

    private fun convertTo() {
        binding.fabImageConverter.setOnClickListener() { presenter.showImageConverter() }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onBackPressed(): Boolean = presenter.onBackPressed()

    override fun onItemClick(gitHubUser: GithubUser) {
        presenter.showDetails(gitHubUser)
    }
}