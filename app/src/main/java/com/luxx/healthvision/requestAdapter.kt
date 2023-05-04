package com.luxx.healthvision

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class requestAdapter(private val requestList:ArrayList<requestData>,
                     private val context: Context
                     ) : RecyclerView.Adapter<requestAdapter.requestViewHolder>() {

    var onItemClick: ((requestData) -> Unit)? = null

    class requestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val med: TextView = itemView.findViewById(R.id.requestDescription)
        val type: TextView = itemView.findViewById(R.id.requestLandmark)
        val meal: TextView = itemView.findViewById(R.id.requestLocation)
        val status: TextView = itemView.findViewById(R.id.requestStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): requestViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return requestViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: requestViewHolder, position: Int) {
        val request = requestList[position]
        holder.med.text = request.des
        holder.type.text = request.landmark
        holder.meal.text = request.location
        holder.status.text = request.status

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(request)
        }
    }

    override fun getItemCount(): Int {
        return requestList.size
    }
}