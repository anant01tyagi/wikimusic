package com.example.musicwiki.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.models.Image
import com.example.musicwiki.models.artistTopALbum
import com.example.musicwiki.models.artistTopTrack
import com.example.musicwiki.models.tagInfo
import com.squareup.picasso.Picasso

class artistScreenTrackRVadapter : RecyclerView.Adapter<artistScreenTrackRVadapter.MyViewHolder>()  {

    var items = ArrayList<artistTopTrack>()

    fun setUpdatedItems(items: ArrayList<artistTopTrack>) {
        this.items = items
        notifyDataSetChanged()


    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val artistTrackName = view.findViewById<TextView>(R.id.artistTrackName)
        val artistTrackImage = view.findViewById<ImageView>(R.id.artistTrackImage)

        fun bind(data : artistTopTrack){
            artistTrackName.text = data.artistTopTrackName

            val url = data.artistTopTrackImage.get(2).artistTopTrackImageUrl

            Picasso.get()
                .load(url)
                .into(artistTrackImage)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.artistscreen_toptracks_layout, parent, false)

        return artistScreenTrackRVadapter.MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }
}