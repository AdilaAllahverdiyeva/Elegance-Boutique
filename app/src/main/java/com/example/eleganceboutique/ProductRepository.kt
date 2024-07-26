package com.example.eleganceboutique

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class ProductRepository {
    private val db = FirebaseFirestore.getInstance()

    fun getProducts(): Task<QuerySnapshot> {
        return db.collection("products").get()
    }
}
