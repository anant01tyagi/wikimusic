package com.example.musicwiki.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.models.album
import com.example.musicwiki.models.track
import com.squareup.picasso.Picasso

class tracksRVadapter : RecyclerView.Adapter<tracksRVadapter.MyViewHolder>() {

    var items = ArrayList<track>()

    fun setUpdatedItems(items: ArrayList<track>) {
        this.items = items
        notifyDataSetChanged()


    }



    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val trackImage = view.findViewById<ImageView>(R.id.trackImage)
        val trackName = view.findViewById<TextView>(R.id.trackName)
        val trackArtist = view.findViewById<TextView>(R.id.trackArtist)

        fun bind(data : track){

            trackName.text = data.trackName
            trackArtist.text = data.trackArtist.trackArtistName
            val imageurl = data.trackImage.get(2).trackImageUrl

            Picasso.get()
                .load(imageurl)
                .into(trackImage)

        }

    }


        override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): tracksRVadapter.MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.toptracks_layout, parent, false)

            return tracksRVadapter.MyViewHolder(view)
        }

    override fun onBindViewHolder(holder: tracksRVadapter.MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}