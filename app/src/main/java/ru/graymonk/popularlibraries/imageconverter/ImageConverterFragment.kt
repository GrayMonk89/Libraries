package ru.graymonk.popularlibraries.imageconverter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.graymonk.popularlibraries.PopApp
import ru.graymonk.popularlibraries.core.OnBackPressedListener
import ru.graymonk.popularlibraries.databinding.FragmentImageConverterBinding


class ImageConverterFragment: MvpAppCompatFragment(), OnBackPressedListener, ImageConverterView {

    private var _binding : FragmentImageConverterBinding? = null
    private val binding: FragmentImageConverterBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageConverterBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val presenter: ImageConverterPresenter by moxyPresenter {
        ImageConverterPresenter(PopApp.instance.router)
    }

    companion object{
        fun newInstance() = ImageConverterFragment()
    }

    override fun onBackPressed(): Boolean = presenter.onBackPressed()
}