package com.budjet.ok.oop

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.budjet.ok.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

object FabColorChange {
    fun changeColor(fab:FloatingActionButton,colorTintList:Int, context: Context){
        var checked = true
        fab.scaleType = ImageView.ScaleType.CENTER
        fab.setOnClickListener {
            if(checked){
                checked=false
                fab.imageTintList
                fab.backgroundTintList = ContextCompat.getColorStateList(context,colorTintList)
            }
            else{
                fab.backgroundTintList = ContextCompat.getColorStateList(context,R.color.icon_inactive)
                checked=true
            }
        }
    }
}