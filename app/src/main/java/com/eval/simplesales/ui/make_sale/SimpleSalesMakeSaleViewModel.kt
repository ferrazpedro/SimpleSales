package com.eval.simplesales.ui.make_sale

import androidx.lifecycle.ViewModel
import com.eval.simplesales.domain.usecases.GetSalesUC
import com.eval.simplesales.domain.usecases.PostSaleUC

class SimpleSalesMakeSaleViewModel(
    private val getSalesUC: GetSalesUC,
    private val postSaleUC: PostSaleUC
): ViewModel() {

}