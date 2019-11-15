package com.example.stockmanager.models

import com.example.stockmanager.common.Utils
import com.example.stockmanager.dataProvider.Provider

class Category(var name: String): DataModel {
    override val id = Utils.getUniqueId("category")
    val itemIds = ArrayList<String>()

    override fun save(callback: () -> Unit) {
        Provider.saveCategory(this)
        callback()
    }

    override fun update(callback: () -> Unit) {
        val latestCategory = Provider.getCategory(this.id)

        this.name = latestCategory.name
        this.itemIds.clear()
        this.itemIds.addAll(latestCategory.itemIds)

        callback()
    }
}