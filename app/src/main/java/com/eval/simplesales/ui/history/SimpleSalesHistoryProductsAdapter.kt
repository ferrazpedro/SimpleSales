package com.eval.simplesales.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.eval.simplesales.R
import com.eval.simplesales.domain.models.Product

class SimpleSalesHistoryProductsAdapter(private val products: ArrayList<Product?>) :
    RecyclerView.Adapter<SimpleSalesHistoryProductsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.simplesales_product_history_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = products[position]

        if (item != null) {
            holder.itemView.findViewById<AppCompatTextView>(R.id.client_name_value_textview).text = item.name
            holder.itemView.findViewById<AppCompatTextView>(R.id.total_quantity_value_textview).text =
                item.quantity.toString()
            holder.itemView.findViewById<AppCompatTextView>(R.id.price_value_textview).text =
                item.price.toString()
            holder.itemView.findViewById<AppCompatTextView>(R.id.total_price_value_textview).text =
                item.totalPrice.toString()
            holder.itemView.findViewById<AppCompatTextView>(R.id.description_value_textview).text =
                item.description
        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}