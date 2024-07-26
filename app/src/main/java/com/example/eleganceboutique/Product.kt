package com.example.eleganceboutique

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val name: String = "",
    val price: Double = 0.0,
    val image: String = ""
) : Parcelable
