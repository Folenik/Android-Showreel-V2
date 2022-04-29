package com.folen.androidshowreelv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val itemList: List<TestListItem>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val TestListItem = itemList[position]

        holder.itemHeader.text = TestListItem.header
        holder.itemDescription.text = TestListItem.description
        holder.itemImage.setImageResource(TestListItem.image)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val itemHeader = itemView.findViewById(R.id.listItemHeader) as TextView
        val itemDescription = itemView.findViewById(R.id.listItemDescription) as TextView
        val itemImage = itemView.findViewById(R.id.listItemImage) as ImageView
    }

}
