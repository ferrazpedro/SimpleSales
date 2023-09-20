package com.eval.simplesales.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.eval.simplesales.domain.models.Product
import com.eval.simplesales.domain.models.Sale
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
@Entity(tableName = "sales")
class SalesBD(

    @ColumnInfo(name = "sale_id")
    @PrimaryKey
    val saleId: Int,

    @ColumnInfo(name = "client")
    val client: String?,

    @ColumnInfo(name = "products")
    val products: String
) {
    @Ignore
    constructor(
        saleId: Int,
        client: String?,
        products: ArrayList<Product?>
    ): this(
        saleId = saleId,
        client = client,
        products = Converters.convertProductsToGson(products)
    )

    fun convertBDtoModel(saleBD: SalesBD) = Sale(
        saleId = saleBD.saleId,
        client = saleBD.client,
        products = Converters.convertJsonToProducts(saleBD.products)
    )
}