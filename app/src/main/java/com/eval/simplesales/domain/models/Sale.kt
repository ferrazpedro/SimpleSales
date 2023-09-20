package com.eval.simplesales.domain.models

import java.io.Serializable

data class Sale(
    val saleId: Int,
    val client: String?,
    val products: ArrayList<Product?>
) : Serializable