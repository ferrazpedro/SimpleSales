package com.eval.simplesales.data.repositories

import com.eval.simplesales.data.mappers.Converters
import com.eval.simplesales.domain.models.Sale
import com.eval.simplesales.domain.repository.SaleRepository
import com.eval.simplesales.utils.db
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
class SaleRepositoryImpl(): SaleRepository {
    override suspend fun getSales(): ArrayList<Sale?> {
        val dao = db.salesDAO()
        val list = dao.getAll()
        val sales = arrayListOf<Sale?>()

        for (sale in list) {
            if (sale != null) {
                sales.add(Converters.convertSaleEntitytoModel(sale))
            }
        }

        return sales
    }

    override suspend fun insertSale(sale: Sale) {
        val dao = db.salesDAO()

        dao.insertSale(sale)
    }
}