package com.folen.androidshowreelv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FeatureListAdapter(private val featureList: List<Feature>) :
    RecyclerView.Adapter<FeatureListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.feature_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val featureListItem = featureList[position]

        holder.itemName.text = featureListItem.name
        holder.itemDescription.text = featureListItem.description
        Glide.with(holder.itemView.context)
            .load(featureListItem.image)
            .fitCenter()
            .placeholder(R.drawable.ic_loading)
            .into(holder.itemImage);
    }

    override fun getItemCount(): Int {
        return featureList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName = itemView.findViewById(R.id.featureListItemName) as TextView
        val itemDescription = itemView.findViewById(R.id.featureListItemDescription) as TextView
        val itemImage = itemView.findViewById(R.id.featureListItemImage) as ImageView
    }

}
