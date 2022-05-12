package com.folen.androidshowreelv2.features.constraintlayout

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ceylonlabs.imageviewpopup.ImagePopup
import com.folen.androidshowreelv2.databinding.ActivityConstraintLayoutBinding
import com.folen.androidshowreelv2.utilities.Constants.CONSTRAINT_LAYOUT_INSPIRATION_IMAGE_URL

class ConstraintLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConstraintLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraintLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.clickMe.setOnClickListener {
            showLayoutInspirationImage()
        }
    }

    private fun showLayoutInspirationImage() {
        val imagePopup = ImagePopup(this)
        imagePopup.windowHeight = 800
        imagePopup.windowWidth = 800
        imagePopup.isFullScreen = true
        imagePopup.isHideCloseIcon = true
        imagePopup.isImageOnClickClose = true
        imagePopup.backgroundColor = Color.parseColor("#10FFFFFF")
        imagePopup.initiatePopupWithGlide(CONSTRAINT_LAYOUT_INSPIRATION_IMAGE_URL)
        imagePopup.viewPopup()
    }
}