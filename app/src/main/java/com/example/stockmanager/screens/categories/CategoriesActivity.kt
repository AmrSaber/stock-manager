package com.example.stockmanager.screens.categories

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanager.R
import com.example.stockmanager.common.ui.BaseActivity
import com.example.stockmanager.dataProvider.Provider
import com.example.stockmanager.models.Category
import com.example.stockmanager.screens.categories.dialogs.AddCategoryDialog
import com.example.stockmanager.screens.categories.recycler.CategoriesRecyclerAdapter

class CategoriesActivity : BaseActivity(R.layout.activity_categories) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize views
        val recycler: RecyclerView = findViewById(R.id.main_recycler)
        val noContentTextView: TextView = findViewById(R.id.main_no_content)
        val addItemView: View = findViewById(R.id.main_add_item)

        // This is a lambda because it will need to be passed to the adapter
        val handleVisibility = {
            val isEmpty = Provider.getCategoryIds().isEmpty()
            recycler.visibility = if (isEmpty) View.INVISIBLE else View.VISIBLE
            noContentTextView.visibility = if (isEmpty) View.VISIBLE else View.INVISIBLE
        }

        handleVisibility()

        // Handle recycler adapter and layout manager
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = CategoriesRecyclerAdapter(this, handleVisibility)

        // Handle addItem onClick
        addItemView.setOnClickListener {
            val addCategoryFragment = AddCategoryDialog { categoryName ->
                if (categoryName.isNotBlank()) {
                    val category = Category(categoryName)
                    category.save {
                        (recycler.adapter!! as CategoriesRecyclerAdapter).updateCategories()
                    }
                }
            }

            addCategoryFragment.show(this.supportFragmentManager, "add_category")
        }

    }
}