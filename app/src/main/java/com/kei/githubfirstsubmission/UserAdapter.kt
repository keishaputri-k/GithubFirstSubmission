package com.kei.githubfirstsubmission

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kei.githubfirstsubmission.data.model.Users
import com.kei.githubfirstsubmission.databinding.ItemUserBinding

class UserAdapter(private val listUsers: ArrayList<Users>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallBack

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallBack){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallBack {
        fun onItemClicked(users: Users)
    }

    class UserViewHolder(var userBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(userBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val userBinding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(userBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val users = listUsers[position]
        Glide.with(holder.itemView.context).load(users.avatar).circleCrop()
            .into(holder.userBinding.ivUserItem)
        holder.userBinding.tvNameUserItem.text = users.name
        holder.userBinding.tvUserNameUserItem.text = users.username
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listUsers[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listUsers.size
}