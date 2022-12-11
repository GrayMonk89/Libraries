package ru.graymonk.popularlibraries

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.graymonk.popularlibraries.databinding.ActivityMainBinding
import kotlin.system.exitProcess


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter { CountersPresenter(CountersModel()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListener()
    }

    private fun setClickListener() {
        with(binding) {
            mainActivityFirstButton.setOnClickListener {
                presenter.onCounterOneClick()
            }
            mainActivitySecondButton.setOnClickListener {
                presenter.onCounterTwoClick()
            }
            mainActivityThirdButton.setOnClickListener {
                presenter.onCounterThirdClick()
            }
        }
    }

    override fun setCounterOneText(counter: String) {
        binding.mainActivityFirstTextView.text = counter
    }

    override fun setCounterTwoText(counter: String) {
        binding.mainActivitySecondTextView.text = counter
    }

    override fun setCounterThirdText(counter: String) {
        binding.mainActivityThirdTextView.text = counter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.actionMainMenuExit -> {
                exitProcess(0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}