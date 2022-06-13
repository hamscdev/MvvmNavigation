package com.devnight.navigations.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devnight.navigations.R
import com.devnight.navigations.data.model.ProductItem

class DashboardAdapter(val listProduct: List<ProductItem>, val context: Context): RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById<TextView>(R.id.title)
        val description = itemView.findViewById<TextView>(R.id.description)
        val price = itemView.findViewById<TextView>(R.id.price)

        fun render(item: ProductItem) {
            title.text = item.name
            description.text = item.description
            price.text = item.price.toString()
        }
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(context)
        return ViewHolder(inflate.inflate(R.layout.item_dashboard, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(listProduct[position])
    }

    override fun getItemCount(): Int = listProduct.size
}