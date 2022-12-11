package ru.graymonk.popularlibraries

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.graymonk.popularlibraries.databinding.ActivityMainBinding
import ru.graymonk.popularlibraries.main.UserAdapter
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.repository.implementation.GithubRepositoryImpl
import kotlin.system.exitProcess


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val adapter = UserAdapter()

    private val presenter by moxyPresenter { CountersPresenter(GithubRepositoryImpl()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        with(binding) {
            rvGithubUsers.layoutManager = LinearLayoutManager(this@MainActivity)
            rvGithubUsers.adapter = adapter
        }
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

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }
}