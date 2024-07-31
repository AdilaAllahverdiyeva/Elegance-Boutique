package com.example.eleganceboutique

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CartViewModel : ViewModel() {
    private val _cartItems = MutableLiveData<MutableList<Product>>(mutableListOf())
    val cartItems: LiveData<MutableList<Product>> get() = _cartItems

    fun addProductToCart(product: Product) {
        _cartItems.value?.add(product)
        _cartItems.value = _cartItems.value // Trigger observers
    }
}
