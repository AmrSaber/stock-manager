package com.example.stockmanager.models

interface DataModel {
    val id: String

    /**
     * Saves the model with its current state to used persistence layer
     */
    fun save(callback: () -> Unit = {})

    /**
     * Gets the latest updates of the model from the persistence layer
     */
    fun update(callback: () -> Unit = {})
}