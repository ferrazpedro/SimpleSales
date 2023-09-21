package com.eval.simplesales.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.eval.simplesales.data.mappers.Converters
import com.eval.simplesales.domain.models.Product
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
@Entity(tableName = "sales")
class SaleEntity(

    @ColumnInfo(name = "sale_id")
    @PrimaryKey
    val saleId: Int,

    @ColumnInfo(name = "client")
    val client: String?,

    @ColumnInfo(name = "total_price")
    val totalPrice: Double?,

    @ColumnInfo(name = "products")
    val products: String
) {
    @Ignore
    constructor(
        saleId: Int,
        client: String?,
        totalPrice: Double?,
        products: ArrayList<Product?>
    ) : this(
        saleId = saleId,
        client = client,
        totalPrice = totalPrice,
        products = Converters.convertProductsToGson(products)
    )
}