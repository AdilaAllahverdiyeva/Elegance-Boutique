package com.example.eleganceboutique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CardFragment : Fragment() {

    private val cartViewModel: CartViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView2)

        val adapter = CartAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        cartViewModel.cartItems.observe(viewLifecycleOwner) { items ->
            adapter.submitList(items)
        }

        return view
    }
}
