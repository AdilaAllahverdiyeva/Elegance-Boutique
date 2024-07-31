package com.example.eleganceboutique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {

    private val args: DetailsFragmentArgs by navArgs()
    private val cartViewModel: CartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        val productImageView = view.findViewById<ImageView>(R.id.ivProductImage)
        val productNameTextView = view.findViewById<TextView>(R.id.tvProductName)
        val productPriceTextView = view.findViewById<TextView>(R.id.tvProductPrice)
        val addToCartButton = view.findViewById<Button>(R.id.btnAddToCart)

        val product = args.product
        Picasso.get().load(product.image).into(productImageView)
        productNameTextView.text = product.name
        productPriceTextView.text = product.price.toString()

        addToCartButton.setOnClickListener {
            cartViewModel.addProductToCart(product)
            findNavController().navigate(R.id.action_detailsFragment_to_cardFragment)
        }

        return view
    }
}
