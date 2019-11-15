package com.example.stockmanager.dataProvider

import com.example.stockmanager.dataProvider.interfaces.DataProvider
import com.example.stockmanager.dataProvider.providers.PaperDataProvider
import com.example.stockmanager.models.Category
import com.example.stockmanager.models.Item

object Provider : DataProvider {
    private val paperDataProvider = PaperDataProvider()

    override fun getCategoryIds() = paperDataProvider.getCategoryIds()
    override fun saveCategoryIds(categoryIds: Array<String>) {
        paperDataProvider.saveCategoryIds(categoryIds)
    }

    override fun getCategory(categoryId: String) = paperDataProvider.getCategory(categoryId)
    override fun saveCategory(category: Category) {
        paperDataProvider.saveCategory(category)
    }

    override fun getItem(itemId: String) = paperDataProvider.getItem(itemId)
    override fun saveItem(item: Item) {
        paperDataProvider.saveItem(item)
    }
}