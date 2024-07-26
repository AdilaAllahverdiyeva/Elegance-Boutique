package com.example.eleganceboutique

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot

class ProductViewModel : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    private val db = FirebaseFirestore.getInstance()

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        val productsRef = db.collection("products")
        productsRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val productList = mutableListOf<Product>()
                for (document: QueryDocumentSnapshot in task.result) {
                    val product = document.toObject(Product::class.java)
                    productList.add(product)
                }
                _products.value = productList
            } else {
            }
        }
    }
}
