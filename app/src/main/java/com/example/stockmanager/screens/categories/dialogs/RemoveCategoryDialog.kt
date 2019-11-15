package com.example.stockmanager.screens.categories.dialogs


import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.stockmanager.R
import com.example.stockmanager.dataProvider.Provider
import com.example.stockmanager.models.Category

class RemoveCategoryDialog(
    private val category: Category,
    private val onCategoryDeleted: () -> Unit
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.activity!!)

        builder.setTitle(R.string.categories_remove_category_confirm)

        builder.setNegativeButton(R.string.cancel) { dialog, _ -> dialog.dismiss() }

        builder.setPositiveButton(R.string.remove) { _, _ ->
            Provider.deleteCategory(category.id)
            onCategoryDeleted()
        }

        return builder.create()
    }
}