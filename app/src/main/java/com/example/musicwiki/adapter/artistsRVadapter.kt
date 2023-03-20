package com.example.musicwiki.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.artistScreen
import com.example.musicwiki.models.staticVariables
import com.example.musicwiki.models.artistinfo
import com.squareup.picasso.Picasso

class artistsRVadapter : RecyclerView.Adapter<artistsRVadapter.MyViewHolder>() {

    var items = ArrayList<artistinfo>()

    fun setUpdatedItems(items: ArrayList<artistinfo>) {
        this.items = items
        notifyDataSetChanged()


    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val artistImage = view.findViewById<ImageView>(R.id.artistImage)
        val artistName = view.findViewById<TextView>(R.id.artistName)
        val layout = view.findViewById<LinearLayout>(R.id.topArtistLayout)

        fun bind(data : artistinfo){

            artistName.text = data.name

            val imageurl = data.image.get(2).artistImageurl

            Picasso.get()
                .load(imageurl)
                .into(artistImage)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.topartists_layout, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
        holder.layout.setOnClickListener {
            staticVariables.artistArtistName = holder.artistName.text.toString()
            Log.d("shit", staticVariables.artistArtistName)

            val intent = Intent(it.context, artistScreen::class.java)
            it.context.startActivity(intent)
        }

    }
}