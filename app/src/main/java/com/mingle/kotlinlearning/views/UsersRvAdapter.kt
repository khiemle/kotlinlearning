package com.mingle.kotlinlearning.views

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mingle.kotlinlearning.databinding.RvItemUserBinding
import com.mingle.kotlinlearning.models.User

class UsersRvAdapter(private var items : ArrayList<User>) : RecyclerView.Adapter<UsersRvAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = RvItemUserBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items.get(position))

    override fun getItemCount(): Int = items.size

    class ViewHolder(private var binding: RvItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.userModel = user
        }
    }

}