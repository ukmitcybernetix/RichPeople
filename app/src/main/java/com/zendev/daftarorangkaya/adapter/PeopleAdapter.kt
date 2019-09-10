package com.zendev.daftarorangkaya.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zendev.daftarorangkaya.R
import com.zendev.daftarorangkaya.model.People

class PeopleAdapter(private val data: List<People>, private val listener: (People) -> Unit) :
    RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return PeopleViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(data[position], listener)
    }

    override fun getItemCount(): Int = data.size

    inner class PeopleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var name: TextView = view.findViewById(R.id.tv_item_name)
        private var founder: TextView = view.findViewById(R.id.tv_item_founder)
        private var photo: ImageView = view.findViewById(R.id.img_item_photo)

        fun bind(people: People, listener: (People) -> Unit) {
            name.text = people.name
            founder.text = people.founder

            Glide.with(itemView.context)
                .load(people.photo)
                .into(photo)

            itemView.setOnClickListener {
                listener(people)
            }
        }
    }
}