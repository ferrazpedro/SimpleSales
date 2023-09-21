package com.eval.simplesales.domain.models

import com.eval.simplesales.utils.zeroDouble
import com.eval.simplesales.utils.zeroInt
import java.io.Serializable

data class Sale(
    val saleId: Int,
    var client: String? = "",
    var totalItens: Int? = zeroInt,
    var totalPrice: Double? = zeroDouble,
    val products: ArrayList<Product?> = arrayListOf()
) : Serializable