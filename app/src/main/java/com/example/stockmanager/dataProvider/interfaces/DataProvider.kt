package com.example.stockmanager.dataProvider.interfaces

import com.example.stockmanager.models.Category
import com.example.stockmanager.models.Item

interface DataProvider {
    fun getCategoryIds(): Array<String>
    fun saveCategoryIds(categoryIds: Array<String>)

    fun getCategory(categoryId: String): Category
    fun saveCategory(category: Category)

    fun getItem(itemId: String): Item
    fun saveItem(item: Item)
}