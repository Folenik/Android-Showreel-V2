package com.folen.androidshowreelv2.utilities.managers

import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreelv2.R
import com.folen.androidshowreelv2.features.constraintlayout.ConstraintLayoutActivity

object IntentManager : AppCompatActivity() {
    fun openNewActivity(context: Context, featureId: Int) {
        lateinit var intent: Intent
        when (featureId) {
            0 -> {
                intent = Intent(context, ConstraintLayoutActivity::class.java)
                startIntent(intent, context)
            }
            else -> Toast.makeText(
                context,
                context.getString(R.string.feature_not_finished),
                LENGTH_LONG
            ).show()
        }
    }

    private fun startIntent(intent: Intent, context: Context) {
        try {
            context.startActivity(intent)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}