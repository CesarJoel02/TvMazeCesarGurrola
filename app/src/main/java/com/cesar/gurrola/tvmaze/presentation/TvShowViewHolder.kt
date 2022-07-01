package com.cesar.gurrola.tvmaze.presentation

import android.content.Context
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cesar.gurrola.tvmaze.R
import com.cesar.gurrola.tvmaze.databinding.TvshowItemBinding
import com.cesar.gurrola.tvmaze.domain.models.TvShowsListDataModelItem
import com.squareup.picasso.Picasso

class TvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = TvshowItemBinding.bind(view)


    fun bind(item: TvShowsListDataModelItem, context: Context) {
        try {
            if (context != null) {
                Picasso.get().load(item.show.image.medium).into(binding.tvShowImage)
                binding.tvshowName.text = item.show.name
                item.show.network.name?.let {
                    binding.tvshowNetworkName.text = it
                }
                binding.tvshowAirdateAirtime.text = String.format(
                    context.getString(R.string.airdate_airtime_placeholder), item.airdate,
                    item.airtime
                )
            }
        } catch (e: Exception) {
            Log.e("TvShowViewHolder", "itemID: $item ${e.localizedMessage}")
        }
    }

}