package ru.graymonk.popularlibraries.user

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.graymonk.popularlibraries.databinding.ItemUserBinding
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.user.detail.OnItemClickListener

class UserAdapter(private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<UserAdapter.GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return GithubUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    inner class GithubUserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //private val tvLogin by lazy { itemView.findViewById<TextView>(R.id.textViewUserLogin) }

        fun bind(item: GithubUser) = with(binding) {
            textViewUserLogin.text = item.login
            imageViewUserAvatar.load(item.avatarUrl)
            itemView.setOnClickListener { onItemClickListener.onItemClick(item) }
        }
    }
}

