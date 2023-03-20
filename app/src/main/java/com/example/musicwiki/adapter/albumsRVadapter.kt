package com.example.musicwiki.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.albumScreen
import com.example.musicwiki.models.staticVariables
import com.example.musicwiki.models.album
import com.squareup.picasso.Picasso

class albumsRVadapter : RecyclerView.Adapter<albumsRVadapter.MyViewHolder>() {

    var items = ArrayList<album>()

    fun setUpdatedItems(items: ArrayList<album>) {
        this.items = items
        notifyDataSetChanged()


    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val ImageThumb = view.findViewById<ImageView>(R.id.ImageThumb)
        val albumTitle = view.findViewById<TextView>(R.id.albumTitle)
        val albumArtist = view.findViewById<TextView>(R.id.albumArtist)
        val linLayout = view.findViewById<LinearLayout>(R.id.topAlbumsLinearLayout)

        fun bind(data : album){

            albumTitle.text = data.albumName
            albumArtist.text = data.albumArtist.artistName
             val imageurl = data.albumImage.get(2).imageUrl

            Picasso.get()
                .load(imageurl)
                .into(ImageThumb)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.topalbums_layout, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))

        holder.linLayout.setOnClickListener{
            staticVariables.albumName = holder.albumTitle.text.toString()
            staticVariables.albumArtistName = holder.albumArtist.text.toString()

            val intent = Intent(it.context, albumScreen::class.java)
            it.context.startActivity(intent)

        }
    }
}