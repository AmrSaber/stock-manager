package com.example.stockmanager.models

import com.example.stockmanager.common.Utils
import com.example.stockmanager.dataProvider.Provider

class Item(
    var name: String,
    var count: Int = 0,
    val categoryId: String
) : DataModel {
    override val id = Utils.getUniqueId("item")

    override fun save(callback: () -> Unit) {
        Provider.saveItem(this)
        callback()
    }

    override fun update(callback: () -> Unit) {
        val latestItem = Provider.getItem(this.id)

        this.name = latestItem.name
        this.count = latestItem.count

        callback()
    }
}