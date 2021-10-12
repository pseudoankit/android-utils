package com.android.lostankit7.util

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.viewPdf(uri: Uri) {
    val browserIntent = Intent(Intent.ACTION_VIEW)
    browserIntent.setDataAndType(uri, "application/pdf")
    val chooser = Intent.createChooser(browserIntent, "title")
    chooser.flags = Intent.FLAG_ACTIVITY_NEW_TASK // optional
    startActivity(chooser)
}