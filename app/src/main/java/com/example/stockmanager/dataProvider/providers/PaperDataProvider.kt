package com.example.stockmanager.dataProvider.providers

import com.example.stockmanager.dataProvider.interfaces.DataProvider
import com.example.stockmanager.models.Category
import com.example.stockmanager.models.Item
import io.paperdb.Paper

class PaperDataProvider : DataProvider {

    @Suppress("PrivatePropertyName")
    private val ALL_CATEGORY_IDS_KEY = "@paper:categories"

    override fun getCategoryIds(): Array<String> =
        Paper.book().read<Array<String>>(ALL_CATEGORY_IDS_KEY, emptyArray())

    override fun saveCategoryIds(categoryIds: Array<String>) {
        Paper.book().write(ALL_CATEGORY_IDS_KEY, categoryIds)
    }

    override fun getCategory(categoryId: String): Category =
        Paper.book().read<Category>(categoryId)

    override fun saveCategory(category: Category) {
        val categoryIds = this.getCategoryIds()

        if (category.id !in categoryIds) {
            val newCategoryIds = categoryIds.plus(category.id)
            this.saveCategoryIds(newCategoryIds)
        }

        Paper.book().write(category.id, category)
    }

    override fun deleteCategory(categoryId: String) {
        val categoryIds = this.getCategoryIds()
        val newCategoryIds = categoryIds.filter { it != categoryId}
        this.saveCategoryIds(newCategoryIds.toTypedArray())

        Paper.book().delete(categoryId)
    }

    override fun getItem(itemId: String): Item =
        Paper.book().read<Item>(itemId)

    override fun saveItem(item: Item) {
        Paper.book().write(item.id, item)
    }

    override fun deleteItem(itemId: String) {
        Paper.book().delete(itemId)
    }
}