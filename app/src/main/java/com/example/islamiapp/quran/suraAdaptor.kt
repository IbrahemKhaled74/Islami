package com.example.islamiapp.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R

class suraAdaptor(var suraName: List<String>) : RecyclerView.Adapter<suraAdaptor.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sura_name, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.suraName.text = suraName.get(position)
        if (onItemSelectListener != null) {
            holder.itemView.setOnClickListener {
                onItemSelectListener?.onClick(position, suraName.get(position))
            }
        }
    }

    override fun getItemCount(): Int = suraName.size

    var onItemSelectListener: OnItemSelectListener? = null

    interface OnItemSelectListener {
        fun onClick(position: Int, sura: String)
    }

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var suraName: TextView = itemView.findViewById(R.id.sura_name)

    }

}