package com.example.stockmanager.screens.items

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanager.R
import com.example.stockmanager.common.Utils
import com.example.stockmanager.common.ui.BaseActivity
import com.example.stockmanager.dataProvider.Provider
import com.example.stockmanager.screens.items.dialogs.AddItemDialog
import com.example.stockmanager.screens.items.recycler.ItemsRecyclerAdapter
import java.lang.Math.PI

class ItemsActivity : BaseActivity(R.layout.activity_items) {

    companion object {
        private const val CATEGORY_ID_KEY = "@items:keys:category-id"

        fun start(callerActivity: Activity, categoryId: String) {
            val intent = Intent(callerActivity, ItemsActivity::class.java).apply {
                putExtra(CATEGORY_ID_KEY, categoryId)
            }

            callerActivity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get category id from caller intent
        val categoryId = intent.getStringExtra(CATEGORY_ID_KEY)

        // Initialize views
        val recycler: RecyclerView = this.findViewById(R.id.items_recycler)
        val noContentTextView: TextView = this.findViewById(R.id.items_no_content)
        val addButton: View = this.findViewById(R.id.items_add)
        val backButton: View = this.findViewById(R.id.items_back)

        // This is a lambda because it will need to be passed to the adapter
        val handleVisibility = {
            val isEmpty = Provider.getCategoryIds().isEmpty()
            recycler.visibility = if (isEmpty) View.INVISIBLE else View.VISIBLE
            noContentTextView.visibility = if (isEmpty) View.VISIBLE else View.INVISIBLE
        }

        handleVisibility()

        // Handle recycler adapter and layout manager
        recycler.layoutManager = LinearLayoutManager(this)
        val recyclerAdapter = ItemsRecyclerAdapter(categoryId, handleVisibility, this)
        recycler.adapter = recyclerAdapter

        addButton.setOnClickListener {
            val addDialog = AddItemDialog(categoryId) { recyclerAdapter.updateItems() }
            addDialog.show(this.supportFragmentManager, "add_item")
        }

        backButton.setOnClickListener { this.finish() }
        if (Utils.Locale.languageCode == "ar") {
            backButton.rotation = PI.toFloat()
        }
    }
}