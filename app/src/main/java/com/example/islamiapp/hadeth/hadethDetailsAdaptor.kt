package com.example.islamiapp.hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R

class hadethDetailsAdaptor : RecyclerView.Adapter<hadethDetailsAdaptor.viewHolder>() {
    var hadehDetails: List<String>? = null
    fun initList(hadehDetails: List<String>) {
        this.hadehDetails = hadehDetails
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hadeth_details_name, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.hadethDetails.text = hadehDetails?.get(position)

    }

    override fun getItemCount(): Int = hadehDetails?.size ?: 0

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hadethDetails: TextView = itemView.findViewById(R.id.hadeth_name_details)
    }

}