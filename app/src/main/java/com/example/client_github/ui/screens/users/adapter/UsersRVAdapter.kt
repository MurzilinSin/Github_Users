package com.example.client_github.ui.screens.users.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.client_github.databinding.ItemUserBinding
import com.example.client_github.presentation.IUserListPresenter
import com.example.client_github.ui.images.GlideImageLoader

class UsersRVAdapter(
    private val presenter: IUserListPresenter,
    private val imageHolder: GlideImageLoader)
    : RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }
    }

    override fun getItemCount(): Int = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    inner class ViewHolder(private val vb: ItemUserBinding) : RecyclerView.ViewHolder(vb.root),
        UserItemView, View.OnClickListener {
        override var pos: Int = -1
        override fun showLogin(login: String?) {
            vb.tvLogin.text = login
        }

        override fun showAvatar(url: String) {
            imageHolder.loadTo(url, vb.avatarImage)
        }

        override fun onClick(v: View?) {
        }
    }
}