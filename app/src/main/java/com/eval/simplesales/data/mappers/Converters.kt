package com.eval.simplesales.data.mappers

import android.text.TextUtils
import androidx.room.TypeConverter
import com.eval.simplesales.data.local.entities.SaleEntity
import com.eval.simplesales.domain.models.Product
import com.eval.simplesales.domain.models.Sale
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@ExperimentalSerializationApi
object Converters {

    @TypeConverter
    fun convertProductsToGson(products: ArrayList<Product?>): String =
        Json.encodeToString(products)

    @TypeConverter
    fun convertJsonToProducts(string: String?): ArrayList<Product?> =
        if (TextUtils.isEmpty(string) || string == null) {
        arrayListOf()
    } else {
        Json.decodeFromString<ArrayList<Product?>>(string)
    }

    @TypeConverter
    fun convertSaleEntitytoModel(saleBD: SaleEntity) = Sale(
        saleId = saleBD.saleId,
        client = saleBD.client,
        totalPrice = saleBD.totalPrice,
        products = convertJsonToProducts(saleBD.products)
    )
}