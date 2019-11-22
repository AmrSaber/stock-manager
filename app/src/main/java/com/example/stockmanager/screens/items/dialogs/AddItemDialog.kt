package com.example.stockmanager.screens.items.dialogs

import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.stockmanager.R
import com.example.stockmanager.dataProvider.Provider
import com.example.stockmanager.models.Item

class AddItemDialog(
    private val categoryId: String,
    private val onCreateListener: () -> Unit
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.activity!!)

        builder.setTitle(R.string.items_add)

        val view = requireActivity().layoutInflater.inflate(R.layout.dialog_add_item, null)
        builder.setView(view)

        val itemName: TextView = view.findViewById(R.id.dialog_items_name)
        val itemCount: TextView = view.findViewById(R.id.dialog_items_count)
        builder.setPositiveButton(R.string.add) { _, _ ->
            val item = Item(itemName.text.toString(), itemCount.text.toString().toInt(), categoryId)
            Provider.saveItem(item)
            onCreateListener()
        }

        builder.setNegativeButton(R.string.cancel) { dialog, _ -> dialog.dismiss() }

        return builder.create()
    }
}