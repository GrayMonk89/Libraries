package ru.graymonk.popularlibraries.converter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.graymonk.popularlibraries.databinding.FragmentConverterBinding

class ConverterFragment : Fragment() {

    private var _binding: FragmentConverterBinding? = null
    private val binding: FragmentConverterBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConverterBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = ConverterFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
