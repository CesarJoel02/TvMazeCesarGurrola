package com.cesar.gurrola.tvmaze.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cesar.gurrola.tvmaze.R
import com.cesar.gurrola.tvmaze.domain.models.TvShowsListDataModel
import com.cesar.gurrola.tvmaze.presentation.utils.onTvShowClickListener

class TvShowAdapter(
    private val TvShowsList : TvShowsListDataModel,
    private val onTvShowClickListener: onTvShowClickListener
): RecyclerView.Adapter<TvShowViewHolder>() {

    private lateinit var mContext : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        mContext = parent.context
        val layoutInflater = LayoutInflater.from(mContext).inflate(R.layout.tvshow_item, parent, false)
        return TvShowViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val item = TvShowsList[position]
        holder.bind(item, mContext)
        holder.itemView.setOnClickListener {
            onTvShowClickListener.onTvShowClickListener(item)
        }
    }

    override fun getItemCount(): Int = TvShowsList.size

}