package com.eval.simplesales.ui.launcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.eval.simplesales.R
import com.eval.simplesales.databinding.SimplesalesLauncherActivityBinding
import com.eval.simplesales.ui.history.SimpleSalesHistoryActivity
import com.eval.simplesales.ui.make_sale.SimpleSalesMakeSaleActivity
import com.eval.simplesales.utils.Response
import com.eval.simplesales.utils.Status
import com.eval.simplesales.utils.zeroDouble
import org.koin.androidx.viewmodel.ext.android.viewModel

class SimpleSalesLauncherActivity : AppCompatActivity() {

    private val viewModel: SimpleSalesLauncherViewModel by viewModel()

    private lateinit var binding: SimplesalesLauncherActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.simplesales_launcher_activity)
        binding.viewModel = viewModel

        viewModel.getResponseSalesValue().observe(this) { response -> processTotalSales(response) }

        init()
    }

    private fun init() {
        binding.makeSaleButton.setOnClickListener { openMakeSaleActivity() }
        binding.seeHistoryButtom.setOnClickListener { openSalesHistoryActivity() }

        viewModel.getTotalSalesValue()
    }

    private fun openMakeSaleActivity() {
        val intent = Intent(this, SimpleSalesMakeSaleActivity::class.java)
        this.startActivity(intent)
    }

    private fun openSalesHistoryActivity() {
        val intent = Intent(this, SimpleSalesHistoryActivity::class.java)
        this.startActivity(intent)
    }

    private fun processTotalSales(response: Response) {
        when (response.status) {
            Status.SUCCESS -> {
                viewModel.setTotalSales(response.data as Double)
            }

            else -> {
                viewModel.isError.set(true)
                viewModel.setTotalSales(zeroDouble)
            }
        }
    }
}