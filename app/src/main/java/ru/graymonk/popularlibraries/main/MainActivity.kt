package ru.graymonk.popularlibraries.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.graymonk.popularlibraries.PopApp
import ru.graymonk.popularlibraries.R
import ru.graymonk.popularlibraries.core.OnBackPressedListener
import ru.graymonk.popularlibraries.databinding.ActivityMainBinding
import kotlin.system.exitProcess


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val navigator = AppNavigator(this, R.id.containerMain)

//    private val adapter = UserAdapter()

    private val presenter by moxyPresenter { MainPresenter(PopApp.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        PopApp.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        PopApp.instance.navigatorHolder.removeNavigator()
        super.onPause()
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


    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { currentFragment ->
            if (currentFragment is OnBackPressedListener && currentFragment.onBackPressed()) {
                return
            }
        }
        presenter.onBackPressed()
    }
}