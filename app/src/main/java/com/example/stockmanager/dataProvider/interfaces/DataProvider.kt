package com.example.stockmanager.dataProvider.interfaces

import com.example.stockmanager.models.Category
import com.example.stockmanager.models.Item

interface DataProvider {
    fun getCategoryIds(): Array<String>
    fun saveCategoryIds(categoryIds: Array<String>)

    fun saveCategory(category: Category)
    fun getCategory(categoryId: String): Category
    fun deleteCategory(categoryId: String)

    fun saveItem(item: Item)
    fun getItem(itemId: String): Item
    fun deleteItem(item: Item)
}