package com.example.stockmanager.screens.categories.recycler

import android.app.Activity
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanager.R
import com.example.stockmanager.dataProvider.Provider
import com.example.stockmanager.screens.categories.dialogs.RemoveCategoryDialog
import com.example.stockmanager.screens.items.ItemsActivity

class CategoryItemViewHolder(
    itemView: View,
    private val callerActivity: Activity,
    private val categoriesAdapter: CategoriesRecyclerAdapter
) : RecyclerView.ViewHolder(itemView) {
    private val text: TextView = itemView.findViewById(R.id.item_category_text)
    private val spacer: View = itemView.findViewById(R.id.item_category_spacer)

    fun bind(categoryId: String, isLast: Boolean) {
        val category = Provider.getCategory(categoryId)
        this.text.text = category.name

        itemView.setOnClickListener { ItemsActivity.start(callerActivity, categoryId) }

        itemView.setOnLongClickListener {
            val removeCategoryFragment = RemoveCategoryDialog(category) { this.categoriesAdapter.updateCategories() }
            removeCategoryFragment.show(
                this.categoriesAdapter.callerActivity.supportFragmentManager,
                "remove_category"
            )

            true
        }

        spacer.visibility = if (isLast) View.INVISIBLE else View.VISIBLE

    }
}