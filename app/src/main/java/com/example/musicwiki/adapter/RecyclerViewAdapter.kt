package com.example.musicwiki.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.models.staticVariables
import com.example.musicwiki.genreActivity
import com.example.musicwiki.models.TagName

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {


    private var items = ArrayList<TagName>()


    @SuppressLint("NotifyDataSetChanged")
    fun setUpdatedItems(items: ArrayList<TagName>) {
        this.items = items
        notifyDataSetChanged()


    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button: Button? = view.findViewById(R.id.genreName)


        fun bind(data: TagName) {
            button?.setText(data.name)


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_list_layout, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
        holder.button?.setOnClickListener {
            staticVariables.tagName = holder.button?.text.toString()

            val intent = Intent(it.context, genreActivity::class.java)
            it.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}