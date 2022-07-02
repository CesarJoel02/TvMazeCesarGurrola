package com.cesar.gurrola.tvmaze.presentation.talento

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cesar.gurrola.tvmaze.R
import com.cesar.gurrola.tvmaze.domain.models.TvShowCastModel

class TalentoAdapter(
    private val tvSHowCast: TvShowCastModel
): RecyclerView.Adapter<TalentoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TalentoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.talento_item, parent, false)
        return TalentoViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: TalentoViewHolder, position: Int) {
        val item = tvSHowCast[position]
        holder.bind(item)
    }

    override fun getItemCount() = tvSHowCast.size
}