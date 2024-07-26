package com.example.eleganceboutique

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CardFragment : Fragment() {

    private lateinit var cartProducts: MutableList<Product>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card, container, false)

        cartProducts = mutableListOf()

        arguments?.let {
            val product: Product? = it.getParcelable("product")
            product?.let {
                cartProducts.add(it)
            }
        }

        return view
    }
}
