package ru.graymonk.popularlibraries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.graymonk.popularlibraries.databinding.ActivityMainBinding
import ru.graymonk.popularlibraries.utils.Constants


class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        setClickListener()
    }

    private fun setClickListener() {
        with(binding) {
            mainActivityFirstButton.setOnClickListener {
                presenter.onCounterClick(Constants.DEFAULT_VALUE_ZERO)
            }
            mainActivitySecondButton.setOnClickListener {
                presenter.onCounterClick(Constants.DEFAULT_VALUE_ONE)
            }
            mainActivityThirdButton.setOnClickListener {
                presenter.onCounterClick(Constants.DEFAULT_VALUE_TWO)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this, CountersModel())
    }

    override fun setText(id: Int, counter: String) {
        with(binding) {

            when (id) {
                Constants.DEFAULT_VALUE_ZERO -> {
                    mainActivityFirstTextView.text = counter
                }
                Constants.DEFAULT_VALUE_ONE -> {
                    mainActivitySecondTextView.text = counter
                }
                Constants.DEFAULT_VALUE_TWO -> {
                    mainActivityThirdTextView.text = counter
                }
            }
        }
    }
}