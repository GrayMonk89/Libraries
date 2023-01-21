package ru.graymonk.popularlibraries.user.detail.repositorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.graymonk.popularlibraries.PopApp
import ru.graymonk.popularlibraries.core.OnBackPressedListener
import ru.graymonk.popularlibraries.databinding.FragmentRepositoryDetailBinding
import ru.graymonk.popularlibraries.model.GithubRepository


class RepositoryDetailFragment : MvpAppCompatFragment(), OnBackPressedListener,
    RepositoryDetailView {

    private var _binding: FragmentRepositoryDetailBinding? = null
    private val binding: FragmentRepositoryDetailBinding
        get() = _binding!!

    private val presenter: RepositoryDetailPresenter by moxyPresenter {

        val repository =
            arguments?.getParcelable<GithubRepository>(CONST_ARGUMENT_REPOSITORY) as GithubRepository
        RepositoryDetailPresenter(repository, PopApp.instance.router)

    }

    companion object {
        private const val CONST_ARGUMENT_REPOSITORY = "repository"

        @JvmStatic
        fun newInstance(githubRepository: GithubRepository) =
            RepositoryDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(CONST_ARGUMENT_REPOSITORY, githubRepository)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onBackPressed(): Boolean = presenter.onBackPressed()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun show(githubRepository: GithubRepository) {
        with(binding) {
            textViewId.text = githubRepository.id.toString()
            textViewTitle.text = githubRepository.name
            textViewForksCount.text = githubRepository.forks.toString()
        }
    }
}