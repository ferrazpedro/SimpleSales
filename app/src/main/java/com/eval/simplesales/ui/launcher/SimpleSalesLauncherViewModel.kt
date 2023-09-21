package com.eval.simplesales.ui.launcher

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eval.simplesales.domain.usecases.GetTotalSalesValueUC
import com.eval.simplesales.utils.Response
import kotlinx.coroutines.launch

class SimpleSalesLauncherViewModel(
    private val getTotalSalesValueUC: GetTotalSalesValueUC
) : ViewModel() {

    private var responseSalesValue = MutableLiveData<Response>()

    private var totalSales = ""

    var loading = ObservableField(false)
    var isError = ObservableField(false)

    fun getTotalSalesValue() {
        viewModelScope.launch() {
            try {
                val totalSalesValue = getTotalSalesValueUC.execute()

                responseSalesValue.postValue(Response.success(totalSalesValue))
            } catch (t: Throwable) {
                responseSalesValue.postValue(Response.error(t))
            }
        }
    }

    fun getTotalSales(): String = totalSales

    fun setTotalSales(totalSalesValue: Double) {
        totalSales = totalSalesValue.toString()
    }

    fun getResponseSalesValue(): MutableLiveData<Response> = responseSalesValue
}