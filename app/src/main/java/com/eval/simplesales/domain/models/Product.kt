package com.eval.simplesales.domain.models

import com.eval.simplesales.utils.zeroDouble
import java.io.Serializable

data class Product(
    var name: String = "",
    var price: Double = zeroDouble,
    var totalPrice: Double = zeroDouble,
    var quantity: Int = 1,
    var description: String? = ""
) : Serializable