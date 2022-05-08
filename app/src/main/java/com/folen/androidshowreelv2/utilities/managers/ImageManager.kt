package com.folen.androidshowreelv2.utilities.managers

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.folen.androidshowreelv2.R

object ImageManager {
    fun setImageFromUri(context: Context, imageUri: String, destination: ImageView) {
        Glide.with(context)
            .load(imageUri)
            .fitCenter()
            .placeholder(R.drawable.ic_loading)
            .into(destination);
    }
}