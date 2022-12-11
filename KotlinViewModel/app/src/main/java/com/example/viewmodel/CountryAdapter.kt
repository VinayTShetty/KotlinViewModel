package com.example.viewmodel

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewmodel.data.Countries

class CountryAdapter(val activity: Activity) :
    RecyclerView.Adapter<CountryAdapter.ItemViewHoder>() {

    private var countriesList: List<Countries>? = null


    fun setCountryList(countriesList_loc: List<Countries>?) {
        /**
         * Used to update the list
         */
        this.countriesList = countriesList_loc
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHoder {
        /**
         *  1)Inflate the Layout File
         *
         */
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.country_list_row, parent, false)
        return ItemViewHoder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHoder, position: Int) {
        holder.bindData(countriesList?.get(position)!!, activity)
    }

    override fun onBindViewHolder(
        holder: ItemViewHoder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemCount(): Int {
        if (countriesList == null)
            return 0
        else return countriesList!!.size
    }

    override fun onViewRecycled(holder: ItemViewHoder) {
        super.onViewRecycled(holder)
    }

    class ItemViewHoder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flagImage = itemView.findViewById<ImageView>(R.id.flagImage)
        val tvname = itemView.findViewById<TextView>(R.id.tvName)
        val tvCapital = itemView.findViewById<TextView>(R.id.tvCapital)
        val tvRegion = itemView.findViewById<TextView>(R.id.tvRegion)

        fun bindData(data: Countries?, activity: Activity) {
            tvname.text=data!!.name+" "+ data!!.alpha2Code
            tvCapital.text="Capital "+data.capital
            tvRegion.text="Region "+data.region
            Glide.with(activity)
                .load(data.flags?.png)
                .into(flagImage)
        }
    }
}