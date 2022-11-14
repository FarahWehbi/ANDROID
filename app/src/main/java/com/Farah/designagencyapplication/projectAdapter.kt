package com.Farah.designagencyapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProjectAdapter(private val listener: NewsItemClicked) : RecyclerView.Adapter<ProjectViewHolder>() {
    private val items: ArrayList<Projects> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewHolder = ProjectViewHolder(view)
        view.setOnClickListener{
            listener.onItemCliked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(NewsViewHolder, Int){
        val currentItem = items[position]
        holder.titleView=currentItem.title
        holder.description = currentItem.description
        Glide.with(holder.itemView.context).load(currentItem.imageURL).into(holder.image)
    }

}
class ProjectViewHolder(View) :RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.title)
    val image: RecyclerView[0] = itemView.findViewById(R.id.image)
    val author: RecyclerView[1] = itemView.findViewById(R.id.description)
    val date: RecyclerView[2] = itemView.findViewById(R.id.date)
}