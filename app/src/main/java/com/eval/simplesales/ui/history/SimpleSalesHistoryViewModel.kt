package com.eval.simplesales.ui.history

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eval.simplesales.domain.usecases.GetSalesUC
import com.eval.simplesales.utils.Response
import kotlinx.coroutines.launch

class SimpleSalesHistoryViewModel(
    private val getSalesUC: GetSalesUC
): ViewModel() {

    private var responseSales = MutableLiveData<Response>()

    var loading = ObservableField(false)
    var isError = ObservableField(false)

    fun getSales() {
        viewModelScope.launch() {
            try {
                val salesList = getSalesUC.execute()
                responseSales.postValue(Response.success(salesList))
            } catch (t: Throwable) {
                responseSales.postValue(Response.error(t))
            }
        }
    }

    fun getResponseSales(): MutableLiveData<Response> = responseSales
}