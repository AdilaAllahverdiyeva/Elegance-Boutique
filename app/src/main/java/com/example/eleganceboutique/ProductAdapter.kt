package com.example.eleganceboutique

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var productList = listOf<Product>()

    fun setProducts(products: List<Product>) {
        productList = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = productList.size

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImageView: ImageView = itemView.findViewById(R.id.ivProductImage)
        private val productNameTextView: TextView = itemView.findViewById(R.id.tvProductName)
        private val productPriceTextView: TextView = itemView.findViewById(R.id.tvProductPrice)

        fun bind(product: Product) {
            Log.d("ProductAdapter", "Product Image URL: ${product.image}")

            if (product.image.isNotEmpty()) {
                Picasso.get().load(product.image).into(productImageView)
            } else {
            }
            productNameTextView.text = product.name
            productPriceTextView.text = "${product.price}$"

            itemView.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(product)
                it.findNavController().navigate(action)
            }
        }}}