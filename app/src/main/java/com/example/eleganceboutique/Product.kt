package com.example.eleganceboutique

import android.os.Parcelable
import android.security.identity.AccessControlProfileId
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int = 0,
    val name: String = "",
    val price: Double = 0.0,
    val image: String = ""
) : Parcelable
