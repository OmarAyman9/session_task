package com.oa.sessiontask.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Store
import com.oa.sessiontask.R
import com.squareup.picasso.Picasso

class StoresAdapter() : RecyclerView.Adapter<StoresAdapter.StoreListViewHolder>() {
    var storeList: List<Store> = emptyList()

    fun setList(storeList: List<Store>) {
        this.storeList = storeList
        notifyDataSetChanged()
    }

    inner class StoreListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var storeName: TextView = itemView.findViewById(R.id.storeName)
        var img: ImageView = itemView.findViewById(R.id.storeImage)

    }


    override fun onBindViewHolder(holder: StoreListViewHolder, position: Int) {
        var store: Store = storeList[position]
        holder.storeName.text = store.storeID
        Picasso.get().load(store.images.logo).into(holder.img)
    }

    override fun getItemCount(): Int = storeList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreListViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.store_row, parent, false)
        return StoreListViewHolder(view)
    }

}