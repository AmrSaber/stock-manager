package com.example.stockmanager.dataProvider

import com.example.stockmanager.dataProvider.interfaces.DataProvider
import com.example.stockmanager.dataProvider.providers.PaperDataProvider
import com.example.stockmanager.models.Category
import com.example.stockmanager.models.Item

object Provider : DataProvider {
    private val dataProvider = PaperDataProvider()

    override fun saveCategoryIds(categoryIds: Array<String>) {
        dataProvider.saveCategoryIds(categoryIds)
    }

    override fun getCategoryIds() = dataProvider.getCategoryIds()


    override fun saveCategory(category: Category) {
        dataProvider.saveCategory(category)
    }

    override fun getCategory(categoryId: String) = dataProvider.getCategory(categoryId)

    override fun deleteCategory(categoryId: String) {
        dataProvider.deleteCategory(categoryId)
    }


    override fun saveItem(item: Item) {
        dataProvider.saveItem(item)
    }

    override fun getItem(itemId: String) = dataProvider.getItem(itemId)

    override fun deleteItem(item: Item) {
        dataProvider.deleteItem(item)
    }
}