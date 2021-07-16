package com.android.lostankit7.util

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView
import android.widget.Toast

fun Context.showToast(message: String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}

fun TextView.asFontAwesome(isSolid : Boolean = true){
    this.typeface =
        Typeface.createFromAsset(
            context.applicationContext.assets,
            if (isSolid) "fonts/FaSolid5.ttf" else "fonts/FaRegular5.ttf"
        )
}