package com.example.stockmanager.screens.items.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanager.R
import com.example.stockmanager.dataProvider.Provider

class ItemsRecyclerAdapter(
    private val categoryId: String,
    private val onUpdateCallback: () -> Unit,
    private val callerActivity: FragmentActivity
) : RecyclerView.Adapter<ItemsItemViewHolder>() {
    private lateinit var categoryItemIds: Array<String>

    init {
        updateItems()
    }

    fun updateItems() {
        val category = Provider.getCategory(categoryId)
        categoryItemIds = category.itemIds.toTypedArray()

        this.notifyDataSetChanged()

        onUpdateCallback()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_item, parent, false)

        return ItemsItemViewHolder(view, this.callerActivity, this)
    }

    override fun getItemCount() = categoryItemIds.size

    override fun onBindViewHolder(holder: ItemsItemViewHolder, position: Int) {
        holder.bind(categoryItemIds[position], position == categoryItemIds.lastIndex)
    }
}