package com.example.shoppinglist.ui.shoppinglsit

import com.example.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item : ShoppingItem)
}