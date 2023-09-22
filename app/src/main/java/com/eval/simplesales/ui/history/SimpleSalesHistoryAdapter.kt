package com.eval.simplesales.ui.history

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eval.simplesales.R
import com.eval.simplesales.domain.models.Sale

class SimpleSalesHistoryAdapter(
    private val context: Context,
    private val sales: ArrayList<Sale?>
) :
    RecyclerView.Adapter<SimpleSalesHistoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.simplesales_sale_history_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = sales.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = sales[position]

        if (item != null) {
            holder.itemView.findViewById<AppCompatTextView>(R.id.client_name_value_textview).text = item.client
            holder.itemView.findViewById<AppCompatTextView>(R.id.total_quantity_value_textview).text =
                item.totalItens.toString()
            holder.itemView.findViewById<AppCompatTextView>(R.id.total_price_value_textview).text =
                item.totalPrice.toString()

            initRecyclerView(item, holder)
        }
    }

    private fun initRecyclerView(item: Sale, holder: MyViewHolder) {
        holder.itemView.findViewById<RecyclerView>(R.id.products_recyclerView).layoutManager =
            LinearLayoutManager(context)
        holder.itemView.findViewById<RecyclerView>(R.id.products_recyclerView).adapter =
            SimpleSalesHistoryProductsAdapter(item.products)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}