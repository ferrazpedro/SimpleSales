package com.eval.simplesales.ui.make_sale

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.databinding.DataBindingUtil
import com.eval.simplesales.R
import com.eval.simplesales.databinding.SimplesalesMakeSaleActivityBinding

class SimpleSalesMakeSaleActivity: AppCompatActivity() {

    val viewModel: SimpleSalesMakeSaleViewModel by viewModel()

    lateinit var binding: SimplesalesMakeSaleActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: SimplesalesMakeSaleActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.simplesales_make_sale_activity)

        binding.viewModel = viewModel
    }
}