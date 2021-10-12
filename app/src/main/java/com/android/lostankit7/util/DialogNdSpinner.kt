package com.android.lostankit7.util

import android.R
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class Dialog (private val activity: Activity) {

    private lateinit var progressDialog: AlertDialog

    fun showConfirmationDialog(
        title: String,
        message: String,
        isYes: (DialogInterface, Int) -> Unit
    ) {
        val builder = AlertDialog.Builder(activity)
        builder.apply {
            setTitle(title)
            setMessage(message)
            setIcon(R.drawable.ic_dialog_alert)
            setPositiveButton(R.string.yes,DialogInterface.OnClickListener(isYes))
            setNegativeButton(R.string.no) { dialog, _ ->
                dialog.dismiss()
            }
            setCancelable(false)
        }
        return builder.create().show()
    }

    fun showSpinner(spinnerItem: Array<String>, spinner: Spinner, itemClick: (String) -> Unit) {
        val adapter = ArrayAdapter(activity, R.layout.simple_spinner_item, spinnerItem).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.apply {
            this.adapter = adapter
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    itemClick(spinnerItem[position])
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        }
    }
}