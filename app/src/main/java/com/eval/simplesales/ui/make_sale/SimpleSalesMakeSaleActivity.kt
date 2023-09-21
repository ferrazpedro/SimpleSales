package com.eval.simplesales.ui.make_sale

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.databinding.DataBindingUtil
import com.eval.simplesales.R
import com.eval.simplesales.databinding.SimplesalesMakeSaleActivityBinding
import com.eval.simplesales.utils.Response
import com.eval.simplesales.utils.Status
import com.eval.simplesales.utils.zeroDouble

class SimpleSalesMakeSaleActivity: AppCompatActivity() {

    private val viewModel: SimpleSalesMakeSaleViewModel by viewModel()

    lateinit var binding: SimplesalesMakeSaleActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.simplesales_make_sale_activity)
        binding.viewModel = viewModel

        viewModel.getResponsePostSale().observe(this) { response -> processResponsePostSale(response) }

        init()
    }

    private fun processResponsePostSale(response: Response) {
        when (response.status) {
            Status.SUCCESS -> {
                finish()
            }

            else -> {
                viewModel.isError.set(true)
                finish()
            }
        }
    }

    private fun init() {
        initClientNameEditText()
        initProductInfoNameEditText()
        initProductInfoQuantityEditText()
        initProdutInfoPriceEditText()

        viewModel.getSalesForSaleNumber()
        binding.saleNumberValueTextview.text = viewModel.activeSale.saleId.toString()

        updateValues()

        binding.productIncludeButton.setOnClickListener {
            viewModel.includeProductInSale()
            updateValues()
        }

        binding.productSaleSaveButton.setOnClickListener {
            viewModel.postSale()
        }
    }

    private fun updateValues() {
        binding.clientInfoNameEdittext.setText(viewModel.activeSale.client)
        binding.productInfoNameEdittext.setText(viewModel.activeProduct.name)
        binding.productInfoQuantityEdittext.setText(viewModel.activeProduct.quantity)
        binding.productInfoPriceEdittext.setText(viewModel.activeProduct.price.toString())

        binding.productTotalPriceValueTextview.text = viewModel.getTotalPriceInProduct().toString()

        binding.productFinalQuantityValueTextview.text = viewModel.getTotalItensInSale().toString()
        binding.productFinalPriceValueTextview.text = viewModel.getTotalPriceInSale().toString()
    }

    private fun initClientNameEditText() {
        binding.clientInfoNameEdittext.inputType = InputType.TYPE_CLASS_TEXT
        binding.clientInfoNameEdittext.addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    /*nochage*/
                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    /*nochage*/
                }

                override fun onTextChanged(
                    s: CharSequence,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                    viewModel.activeSale.client = binding.clientInfoNameEdittext.text.toString()
                }
            }
        )
    }

    private fun initProductInfoNameEditText() {
        binding.productInfoNameEdittext.inputType = InputType.TYPE_CLASS_TEXT
        binding.productInfoNameEdittext.addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    /*nochage*/
                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    /*nochage*/
                }

                override fun onTextChanged(
                    s: CharSequence,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                    viewModel.activeProduct.name = binding.productInfoNameEdittext.text.toString()
                }
            }
        )
    }

    private fun initProductInfoQuantityEditText() {
        binding.productInfoQuantityEdittext.inputType = InputType.TYPE_CLASS_NUMBER
        binding.productInfoQuantityEdittext.addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    /*nochage*/
                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    /*nochage*/
                }

                override fun onTextChanged(
                    s: CharSequence,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                    viewModel.activeProduct.quantity = binding.productInfoQuantityEdittext.toString().toInt()
                }
            }
        )
    }

    private fun initProdutInfoPriceEditText() {
        binding.productInfoPriceEdittext.inputType = InputType.TYPE_CLASS_NUMBER
        binding.productInfoPriceEdittext.addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    /*nochage*/
                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    /*nochage*/
                }

                override fun onTextChanged(
                    s: CharSequence,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                    viewModel.activeProduct.price = binding.productInfoPriceEdittext.toString().toDouble()
                }
            }
        )
    }
}