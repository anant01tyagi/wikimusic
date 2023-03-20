package com.example.musicwiki.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.albumScreen
import com.example.musicwiki.models.staticVariables
import com.example.musicwiki.models.artistTopALbum
import com.squareup.picasso.Picasso

class artistScreenAlbumRVadapter : RecyclerView.Adapter<artistScreenAlbumRVadapter.MyViewHolder>()  {

    var items = ArrayList<artistTopALbum>()

    fun setUpdatedItems(items: ArrayList<artistTopALbum>) {
        this.items = items
        notifyDataSetChanged()


    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val albumImage = view.findViewById<ImageView>(R.id.artistAlbumImage)
        val albumName = view.findViewById<TextView>(R.id.artistAlbumName)
        val layout = view.findViewById<RelativeLayout>(R.id.artistTopAlbumsLayout)
        var albumArtist = view.findViewById<TextView>(R.id.artistAlbumArtist)

        fun bind(data : artistTopALbum){
            albumName.text = data.name
            albumArtist.text = data.artistTopAlbumName.name

            val url = data.artistTopAlbumImage.get(3).artistTopAlbumImageUrl

            Picasso.get()
                .load(url)
                .into(albumImage)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.artistscreen_topalbums_layout, parent, false)

        return artistScreenAlbumRVadapter.MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))

        holder.layout.setOnClickListener{
            staticVariables.albumName = holder.albumName.text.toString()
            staticVariables.albumArtistName = holder.albumArtist.text.toString()

            val intent = Intent(it.context, albumScreen::class.java)
            it.context.startActivity(intent)
        }
    }
}