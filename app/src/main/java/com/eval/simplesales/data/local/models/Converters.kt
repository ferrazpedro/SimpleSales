package com.eval.simplesales.data.local.models

import android.text.TextUtils
import androidx.room.TypeConverter
import com.eval.simplesales.domain.models.Product
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@ExperimentalSerializationApi
object Converters {

    @TypeConverter
    fun convertProductsToGson(products: ArrayList<Product?>): String {
        return Json.encodeToString(products)
    }

    @TypeConverter
    fun convertJsonToProducts(string: String?): ArrayList<Product?> {
        return if (TextUtils.isEmpty(string) || string == null) {
            arrayListOf()
        } else {
            Json.decodeFromString<ArrayList<Product?>>(string)
        }
    }
}