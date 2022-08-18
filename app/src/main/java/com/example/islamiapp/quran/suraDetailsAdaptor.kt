package com.example.islamiapp.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R

class suraDetailsAdaptor : RecyclerView.Adapter<suraDetailsAdaptor.viewHolder>() {
    var suraDetails: List<String>? = null
    fun initList(suraDetails: List<String>) {
        this.suraDetails = suraDetails
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sura_details_name, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.suraDetails.text = suraDetails?.get(position)

    }

    override fun getItemCount(): Int = suraDetails?.size ?: 0

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var suraDetails: TextView = itemView.findViewById(R.id.sura_name_details)
    }

}