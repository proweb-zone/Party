package com.blizkie.org.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blizkie.org.model.Guests
import com.party.org.R
import com.squareup.picasso.Picasso

class PartyRecyclerAdapter(questList: List<Guests>): RecyclerView.Adapter<PartyRecyclerAdapter.PartyListHolder>() {

    private var questList: MutableList<Guests> = mutableListOf()

    init {
        this.questList.clear()
        this.questList.addAll(questList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartyListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow: View = layoutInflater.inflate(R.layout.row_guests, parent, false)
        return PartyListHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: PartyListHolder, position: Int) {
        holder.PartyListHolder(questList[position])
    }

    override fun getItemCount(): Int {
        return questList.size
    }

    inner class PartyListHolder(view: View): RecyclerView.ViewHolder(view) {

        private var name : TextView = view.findViewById(R.id.first_name)
        private var images : ImageView = view.findViewById(R.id.avatar)

        fun PartyListHolder(quest: Guests)
        {
            name.text = quest.name
            Picasso
                .get()
                .load(quest.avatar)
                .placeholder(R.drawable.account)
                .error(R.drawable.account)
                .resize(150,150)
                .centerCrop()
                .into(images)
        }

    }

}