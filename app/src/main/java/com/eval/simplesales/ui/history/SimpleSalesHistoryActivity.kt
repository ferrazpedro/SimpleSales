package com.eval.simplesales.ui.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eval.simplesales.R
import com.eval.simplesales.databinding.SimplesalesHistoryActivityBinding
import com.eval.simplesales.domain.models.Sale
import com.eval.simplesales.utils.Response
import com.eval.simplesales.utils.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class SimpleSalesHistoryActivity : AppCompatActivity() {

    private val viewModel: SimpleSalesHistoryViewModel by viewModel()

    private lateinit var binding: SimplesalesHistoryActivityBinding

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: SimpleSalesHistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.simplesales_history_activity)
        binding.viewModel = viewModel

        viewModel.getResponseSales().observe(this) { response -> processSales(response) }
    }

    private fun processSales(response: Response) {
        when (response.status) {
            Status.SUCCESS -> {
                initRecyclerView(response.data as ArrayList<Sale?>)
            }

            else -> {
                viewModel.isError.set(true)
            }
        }
    }

    private fun initRecyclerView(sales: ArrayList<Sale?>) {
        recycler = binding.productsRecyclerView
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setItemViewCacheSize(10)

        adapter = SimpleSalesHistoryAdapter(this, sales)
        recycler.adapter = adapter
    }
}