package com.example.eleganceboutique

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class UserFragment : Fragment() {

    private lateinit var tvUserName: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    private lateinit var signOutButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)

        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        tvUserName = view.findViewById(R.id.tvUserName)

        fetchUserData()

        signOutButton.setOnClickListener {
            findNavController().navigate(R.id.action_userFragment_to_loginFragment)
        }

        return view
    }

    private fun fetchUserData() {
        val user = auth.currentUser
        user?.let {
            val uid = it.uid
            val docRef = firestore.collection("users").document(uid)
            docRef.get().addOnSuccessListener { document ->
                if (document != null) {
                    val userName = document.getString("name")
                    tvUserName.text = "Hello $userName"
                } else {
                    Log.d(TAG, "No such document")
                }
            }.addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
        }
    }

    companion object {
        private const val TAG = "UserFragment"
    }
}
