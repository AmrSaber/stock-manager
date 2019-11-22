package com.example.stockmanager.screens.items.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.stockmanager.R
import com.example.stockmanager.dataProvider.Provider
import com.example.stockmanager.models.Item

class RemoveItemDialog(
    private val item: Item,
    private val onDeleteListener: () -> Unit
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.activity!!)

        builder.setTitle(R.string.items_confirm_remove)

        builder.setNegativeButton(R.string.cancel) { dialog, _ -> dialog.dismiss() }

        builder.setPositiveButton(R.string.remove) { _, _ ->
            Provider.deleteItem(item)
            onDeleteListener()
        }

        return builder.create()
    }
}