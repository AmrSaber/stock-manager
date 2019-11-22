package com.example.stockmanager.screens.categories.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanager.R
import com.example.stockmanager.dataProvider.Provider

class CategoriesRecyclerAdapter(
    val callerActivity: FragmentActivity,
    private val onUpdateAction: () -> Unit
) : RecyclerView.Adapter<CategoryItemViewHolder>() {

    private var categoryIds = Provider.getCategoryIds()

    fun updateCategories() {
        categoryIds = Provider.getCategoryIds()
        this.notifyDataSetChanged()
        onUpdateAction()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_category, parent, false)

        return CategoryItemViewHolder(itemView, callerActivity, this)
    }

    override fun getItemCount() = categoryIds.size

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        holder.bind(categoryIds[position], position == categoryIds.lastIndex)
    }
}