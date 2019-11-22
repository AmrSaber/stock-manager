package com.example.stockmanager.screens.items.dialogs

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.stockmanager.R
import com.example.stockmanager.dataProvider.Provider
import com.example.stockmanager.models.Item

class UpdateItemDialog(
    private val item: Item,
    private val onUpdateListener: () -> Unit
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.activity!!)

        builder.setTitle(R.string.items_update)

        builder.setNegativeButton(R.string.cancel) { dialog, _ -> dialog.dismiss() }

        val view = requireActivity().layoutInflater.inflate(R.layout.dialog_item_update, null)
        builder.setView(view)

        val itemCount: EditText = view.findViewById(R.id.dialog_items_update_count)
        itemCount.setText(item.count.toString())

        builder.setPositiveButton(R.string.update) { _, _ ->
            if (itemCount.text.toString().isNotBlank()) {
                item.count = itemCount.text.toString().toInt()
                item.save(onUpdateListener)
            }
        }

        return builder.create()
    }
}