package com.example.client_github.ui.screens.repos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.client_github.databinding.ItemRepoBinding
import com.example.client_github.presentation.IReposListPresenter

class RepoRVAdapter(private val presenter: IReposListPresenter)
    : RecyclerView.Adapter<RepoRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount(): Int = presenter.getCount()

    inner class ViewHolder(private val vb: ItemRepoBinding): RecyclerView.ViewHolder(vb.root),
            RepoItemView, View.OnClickListener {
        override var pos: Int = -1

        override fun showRepoName(name: String) {
            vb.repoName.text = name
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }
}