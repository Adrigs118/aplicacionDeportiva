package com.prueba.aplicaciondeportiva.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.prueba.aplicaciondeportiva.R

class DialogAux (val typeDialog : TypeDialog, val message : String, val positiveButton : Boolean) : DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)

            if(positiveButton){
                builder.setMessage(message)
                    .setPositiveButton("YES",
                        DialogInterface.OnClickListener { dialog, id ->
                            // FIRE ZE MISSILES!
                        })
                    .setNegativeButton("Cancel",
                        DialogInterface.OnClickListener { dialog, id ->
                            // User cancelled the dialog
                        })
            }
            else{
                builder.setMessage(message)
            }

            if (typeDialog == TypeDialog.WARNING) {
                builder.setIcon(R.mipmap.dialog_warning)
                builder.setTitle("Warning")
            }
            else if(typeDialog == TypeDialog.ERROR) {
                builder.setIcon(R.mipmap.dialog_error)
                builder.setTitle("Error")
            }
            else {
                builder.setIcon(R.mipmap.dialog_information)
                builder.setTitle("Information")
            }

            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    enum class TypeDialog {INFORMATION, WARNING, ERROR}
}