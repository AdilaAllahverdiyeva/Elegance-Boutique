package com.example.eleganceboutique

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

object Utils {
    fun getImageUrl(imagePath: String, callback: (String?) -> Unit) {
        val storageReference: StorageReference = FirebaseStorage.getInstance().reference.child(imagePath)
        storageReference.downloadUrl.addOnSuccessListener { uri ->
            callback(uri.toString())
        }.addOnFailureListener {
            callback(null)
        }
    }
}
