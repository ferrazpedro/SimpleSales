package com.eval.simplesales.domain.models

import java.io.Serializable

data class Product(
    val productId: Int,
    var name: String?,
    var price: Double?,
    var quantity: Int?,
    var description: String?
) : Serializable