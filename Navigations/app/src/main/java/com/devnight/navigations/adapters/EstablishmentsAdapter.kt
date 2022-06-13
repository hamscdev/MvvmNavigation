package com.devnight.navigations.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import com.bumptech.glide.request.RequestOptions
import com.devnight.navigations.R
import com.devnight.navigations.data.model.StoreItem

class EstablishmentsAdapter(val listEstablisments: List<StoreItem>, val context: Context): RecyclerView.Adapter<EstablishmentsAdapter.ViewHolder>() {

    class ViewHolder (itemsView: View): RecyclerView.ViewHolder(itemsView) {

        val name = itemsView.findViewById<TextView>(R.id.titleEstablishments)
        val address = itemsView.findViewById<TextView>(R.id.addressEstablishments)
        val image = itemsView.findViewById<ImageView>(R.id.imagerestablishments)


        fun render(item: StoreItem,context: Context) {
            name.setText(item.name)
            address.setText(item.address)
            Glide.with(context).load(item.image).fitCenter().into(image)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflaterLayout = LayoutInflater.from(parent.context)
        return ViewHolder(inflaterLayout.inflate(R.layout.adapter_establisments, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(listEstablisments[position], context)
    }

    override fun getItemCount(): Int = listEstablisments.size
}