package com.example.stockmanager.screens.categories.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.stockmanager.R

class AddCategoryDialog(private val onCreateClickListener: (String) -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.activity!!)

        builder.setTitle(R.string.categories_add_category)

        val view = requireActivity().layoutInflater.inflate(R.layout.dialog_add_category, null)
        builder.setView(view)

        val categoryNameTextView: TextView = view.findViewById(R.id.categories_dialog_category_name)
        builder.setPositiveButton(R.string.add) { _, _ -> onCreateClickListener(categoryNameTextView.text.toString()) }

        builder.setNegativeButton(R.string.cancel) { dialog, _ -> dialog.dismiss() }

        return builder.create()
    }
}