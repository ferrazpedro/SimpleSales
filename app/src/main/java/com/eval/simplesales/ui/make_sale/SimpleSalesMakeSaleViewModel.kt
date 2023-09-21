package com.eval.simplesales.ui.make_sale

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eval.simplesales.domain.models.Product
import com.eval.simplesales.domain.models.Sale
import com.eval.simplesales.domain.usecases.GetSalesUC
import com.eval.simplesales.domain.usecases.PostSaleUC
import com.eval.simplesales.utils.Response
import com.eval.simplesales.utils.zeroDouble
import com.eval.simplesales.utils.zeroInt
import kotlinx.coroutines.launch

class SimpleSalesMakeSaleViewModel(
    private val getSalesUC: GetSalesUC,
    private val postSaleUC: PostSaleUC
) : ViewModel() {

    lateinit var activeSale: Sale
    var activeProduct = Product()

    private var responsePostSale = MutableLiveData<Response>()

    var loading = ObservableField(false)
    var isError = ObservableField(false)

    fun getSalesForSaleNumber() {
        viewModelScope.launch() {
            activeSale = try {
                val salesList = getSalesUC.execute()
                Sale(saleId = salesList.size)
            } catch (t: Throwable) {
                Sale(saleId = zeroInt)
            }
        }
    }

    fun includeProductInSale() {
        activeSale.products.add(activeProduct)
        activeProduct = Product()
    }

    fun getTotalPriceInProduct(): Double {
        activeProduct.totalPrice = activeProduct.price * activeProduct.quantity

        return activeProduct.totalPrice
    }

    fun getTotalItensInSale(): Int {
        var itens = zeroInt
        for (product in activeSale.products) {
            product?.quantity?.let { itens += it }
        }
        return itens
    }

    fun getTotalPriceInSale(): Double {
        var price = zeroDouble
        for (product in activeSale.products) {
            product?.price?.let { price += it }
        }
        return price
    }

    fun postSale() {
        viewModelScope.launch {
            try {
                postSaleUC.execute(activeSale)
                responsePostSale.postValue(Response.success(activeSale))
            } catch (t: Throwable) {
                throw t
            }
        }
    }

    fun getResponsePostSale(): MutableLiveData<Response> = responsePostSale
}