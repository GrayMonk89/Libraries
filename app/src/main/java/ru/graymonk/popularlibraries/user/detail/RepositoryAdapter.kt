package ru.graymonk.popularlibraries.user.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.graymonk.popularlibraries.databinding.ItemRepositoryBinding
import ru.graymonk.popularlibraries.model.GithubRepository

typealias OnRepoClickListener = (repository: GithubRepository) -> Unit

class RepositoryAdapter(private val onRepoClickListener: OnRepoClickListener) :
    RecyclerView.Adapter<RepositoryAdapter.GithubUserRepositoryViewHolder>() {
    var repository: List<GithubRepository> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GithubUserRepositoryViewHolder = GithubUserRepositoryViewHolder(
        ItemRepositoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount(): Int = repository.size

    override fun onBindViewHolder(holder: GithubUserRepositoryViewHolder, position: Int) {
        holder.bind(repository[position])
    }


    inner class GithubUserRepositoryViewHolder(private val binding: ItemRepositoryBinding) :
        ViewHolder(binding.root) {
        fun bind(item: GithubRepository) = with(binding) {
            textViewName.text = item.name
            root.setOnClickListener {
                onRepoClickListener.invoke(item)
            }
        }
    }
}


