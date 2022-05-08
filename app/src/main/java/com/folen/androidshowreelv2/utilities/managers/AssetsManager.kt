package com.folen.androidshowreelv2.utilities.managers

import android.content.Context
import java.io.IOException
import kotlin.text.Charsets.UTF_8

object AssetsManager {
    fun loadJsonFromAssets(context: Context, name: String): String? {
        val result: String = try {
            val inputStream = context.assets.open(name)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return result
    }
}