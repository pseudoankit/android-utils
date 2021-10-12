package com.android.lostankit7.util

import android.app.Activity
import android.app.AlertDialog
import com.android.lostankit7.R

fun Activity.showProgressDialog(): AlertDialog? {
    val builder = AlertDialog.Builder(this)
    val inflater = this.layoutInflater
    builder.setView(inflater.inflate(R.layout.custom_dialog,null))  //inflate your custom layout to display in alert dialog
    builder.setCancelable(false)

    return builder.create()
}

fun AlertDialog.hideProgressDialog() {
    this.dismiss()
}

/*
*
*show image on dialog
fun Context.showImageOnDialog(uri: Uri) {
    val builder = Dialog(this)
    builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
    builder.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    builder.setOnDismissListener{
        builder.dismiss()
    }
    val imageView = PhotoView(this)
    Picasso.get().load(uri).into(imageView)
    builder.addContentView(
        imageView, RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    )
    builder.show()
}
*
*/