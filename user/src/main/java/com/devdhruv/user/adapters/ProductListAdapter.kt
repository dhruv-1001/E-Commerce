package com.devdhruv.user.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devdhruv.user.databinding.ProductItemBinding
import com.devdhruv.user.model.Product

class ProductListAdapter (
    private val clickListener: ProductClickListener
): ListAdapter<Product, ProductListAdapter.ViewHolder>(ViewTodoDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    class ViewHolder private constructor(
        private val binding: ProductItemBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(item: Product, clickListener: ProductClickListener) {
            binding.product = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ProductItemBinding.inflate(
                    layoutInflater, parent, false
                )
                return ViewHolder(binding)
            }
        }

    }

}

class ProductClickListener(val clickListener: (product: Product) -> Unit){
    fun onClick(product: Product) = clickListener(product)
}

class ViewTodoDiffCallBack: DiffUtil.ItemCallback<Product>(){
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.productName == newItem.productName
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

}