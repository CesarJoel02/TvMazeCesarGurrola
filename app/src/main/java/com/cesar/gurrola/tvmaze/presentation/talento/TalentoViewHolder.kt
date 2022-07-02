package com.cesar.gurrola.tvmaze.presentation.talento

import android.opengl.Visibility
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cesar.gurrola.tvmaze.databinding.TalentoItemBinding
import com.cesar.gurrola.tvmaze.domain.models.TvShowCastModelItem
import com.squareup.picasso.Picasso

class TalentoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = TalentoItemBinding.bind(view)

    fun bind(item: TvShowCastModelItem) {
        try {
            binding.progressCircular.visibility = View.VISIBLE
            Picasso.get().load(item.person.image.medium).into(binding.iamgeTalento)
            binding.textTalentoName.text = item.person.name
            binding.progressCircular.visibility = View.GONE
        } catch (e: Exception) {
            Log.e("TalentoViewHolder", e.localizedMessage)
        }
    }

}