package com.example.stockmanager.screens.items.recycler

import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanager.R
import com.example.stockmanager.dataProvider.Provider
import com.example.stockmanager.screens.items.dialogs.RemoveItemDialog
import com.example.stockmanager.screens.items.dialogs.UpdateItemDialog

class ItemsItemViewHolder(
    itemView: View,
    private val callerActivity: FragmentActivity,
    private val itemsRecyclerAdapter: ItemsRecyclerAdapter
) : RecyclerView.ViewHolder(itemView) {

    private val itemTitleTextView: TextView = itemView.findViewById(R.id.item_item_text)
    private val itemCountTextView: TextView = itemView.findViewById(R.id.item_item_count)
    private val itemTakeView: View = itemView.findViewById(R.id.item_item_take)
    private val itemAddView: View = itemView.findViewById(R.id.item_item_add)
    private val spacer: View = itemView.findViewById(R.id.item_item_spacer)

    fun bind(itemId: String, isLast: Boolean) {
        val item = Provider.getItem(itemId)

        itemTitleTextView.text = item.name
        itemCountTextView.text = item.count.toString()

        itemTakeView.setOnClickListener {
            --item.count
            item.save { itemCountTextView.text = item.count.toString() }
        }

        itemAddView.setOnClickListener {
            ++item.count
            item.save { itemCountTextView.text = item.count.toString() }
        }

        itemCountTextView.setOnClickListener {
            val updateCountDialog = UpdateItemDialog(item) { itemsRecyclerAdapter.updateItems() }
            updateCountDialog.show(callerActivity.supportFragmentManager, "add_item")
        }

        itemView.setOnLongClickListener {
            val removeItemDialog = RemoveItemDialog(item) { itemsRecyclerAdapter.updateItems() }
            removeItemDialog.show(callerActivity.supportFragmentManager, "delete_item")
            true
        }

        spacer.visibility = if (isLast) View.INVISIBLE else View.VISIBLE
    }
}