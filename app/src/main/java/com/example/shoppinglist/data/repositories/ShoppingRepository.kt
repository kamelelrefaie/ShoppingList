package com.example.shoppinglist.data.repositories

import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.data.db.ShoppingDatabase

class ShoppingRepository(private val db: ShoppingDatabase) {
    suspend fun upsert(item: ShoppingItem) = db.shoppingDao().upsert(item)
    suspend fun delete(item: ShoppingItem) = db.shoppingDao().delete(item)
    fun getAllShoppingItems() = db.shoppingDao().getAllShoppingItems()

}