package com.example.islamiapp.hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R

class hadehAdaptor(var hadethName: List<String>) : RecyclerView.Adapter<hadehAdaptor.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hadeth_name, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.hadetName.text = hadethName.get(position)
        if (onItemSelectListener != null) {
            holder.itemView.setOnClickListener {

                onItemSelectListener?.onItemClick(position, hadethName.get(position))
            }
        }
    }

    var onItemSelectListener: OnItemSelectListener? = null

    interface OnItemSelectListener {
        fun onItemClick(position: Int, hadeth: String)
    }

    override fun getItemCount(): Int = hadethName.size
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hadetName: TextView = itemView.findViewById(R.id.hadeth_name)

    }

}