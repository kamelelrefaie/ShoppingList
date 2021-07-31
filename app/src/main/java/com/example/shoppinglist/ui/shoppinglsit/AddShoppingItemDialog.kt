package com.example.shoppinglist.ui.shoppinglsit

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.databinding.DialogAddShoppingItemBinding

class AddShoppingItemDialog(
    context: Context,
    var addDialogListener: AddDialogListener
) : AppCompatDialog(context) {

    private lateinit var binding: DialogAddShoppingItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()
            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "please enter your information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount = amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()

        }
        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }
}