package com.example.dialogexample

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class MyCustomDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        builder.setMessage("This is the message! Can you see it?!")
        builder.setTitle("This is the title")
        builder.setView(R.layout.dialog_layout)

        builder.setPositiveButton("Yes, sir", DialogInterface.OnClickListener { dialogInterface, i ->
            Log.i("dialog", "You picked yes!")
        })

        builder.setNegativeButton("No, sir", DialogInterface.OnClickListener { dialogInterface, i ->
            Log.i("dialog", "You picked no!")
        })

        return builder.create()
    }
}