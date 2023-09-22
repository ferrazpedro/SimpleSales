package com.eval.simplesales.ui.make_sale

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.eval.simplesales.R
import com.eval.simplesales.domain.models.Product

class SimpleSalesMakeSaleAdapter() :
    RecyclerView.Adapter<SimpleSalesMakeSaleAdapter.MyViewHolder>() {

    private var products: ArrayList<Product> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.simplesales_sale_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = products[position]

        if (item != null) {
            holder.itemView.findViewById<AppCompatTextView>(R.id.sale_item_name).text = item.name
            holder.itemView.findViewById<AppCompatTextView>(R.id.sale_item_quantity).text = item.quantity.toString()
        }
    }

    fun addProduct(product: Product) {
        products.add(product)
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}