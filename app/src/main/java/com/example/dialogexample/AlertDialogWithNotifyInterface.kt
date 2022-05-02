package com.example.dialogexample

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class AlertDialogWithNotifyInterface: DialogFragment() {
    internal lateinit var listener: MyDialogListener

    interface MyDialogListener {
        fun onDialogPositiveClick(dialog: DialogFragment)
        fun OnDialogNegativeClick(dialog: DialogFragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as MyDialogListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        builder.setMessage("This is the message of the third dialog!")
        builder.setTitle("This is the Title!")
        builder.setView(R.layout.dialog_layout)

        builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
            listener.onDialogPositiveClick(this)
        })

        builder.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
            listener.OnDialogNegativeClick(this)
        })

        return builder.create()
    }
}