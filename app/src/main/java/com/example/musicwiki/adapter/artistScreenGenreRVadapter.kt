package com.example.musicwiki.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.models.staticVariables
import com.example.musicwiki.genreActivity
import com.example.musicwiki.models.artistInfoTag

class artistScreenGenreRVadapter : RecyclerView.Adapter<artistScreenGenreRVadapter.MyViewHolder>() {

    var items = ArrayList<artistInfoTag>()

    fun setUpdatedItems(items: ArrayList<artistInfoTag>) {
        this.items = items
        notifyDataSetChanged()


    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val genreButton = view.findViewById<Button>(R.id.genre)

        fun bind(data : artistInfoTag){
            genreButton.text = data.name
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): artistScreenGenreRVadapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.artistscreen_genre_layout, parent, false)

        return artistScreenGenreRVadapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: artistScreenGenreRVadapter.MyViewHolder, position: Int) {
        holder.bind(items.get(position))

        holder.genreButton.setOnClickListener{
            staticVariables.tagName = holder.genreButton.text.toString()

            val intent = Intent(it.context, genreActivity::class.java)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}