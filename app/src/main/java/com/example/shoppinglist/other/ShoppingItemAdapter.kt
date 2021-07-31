package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.databinding.ShoppingItemBinding
import com.example.shoppinglist.ui.shoppinglsit.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val shoppingViewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val view = ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.binding.tvName.text = curShoppingItem.name
        holder.binding.tvAmount.text = "${curShoppingItem.amount}"
        holder.binding.ivDelete.setOnClickListener { shoppingViewModel.delete(curShoppingItem) }

        holder.binding.ivPlus.setOnClickListener {
            curShoppingItem.amount++
            shoppingViewModel.upsert(curShoppingItem)
        }

        holder.binding.ivMinus.setOnClickListener {
            if (curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                shoppingViewModel.upsert(curShoppingItem)
            }
        }

    }


    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingItemViewHolder(val binding: ShoppingItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}