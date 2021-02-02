package com.miskaa.test.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrosid.svgloader.SvgLoader
import com.miskaa.test.MainActivity
import com.miskaa.test.R
import com.miskaa.test.classes.RegionResults

class Adapter internal constructor(
    private val activity: MainActivity,
    private val countryList: ArrayList<RegionResults>

): RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        var country_name: TextView
        var region_name: TextView
        var sub_region_name: TextView
        var population_count: TextView
        var capital_name: TextView
        var languages: TextView
        var flag_icon: ImageView

        init {
            country_name=itemView.findViewById(R.id.country_name)
            region_name=itemView.findViewById(R.id.region_name)
            sub_region_name=itemView.findViewById(R.id.sub_region_name)
            population_count=itemView.findViewById(R.id.population_count)
            capital_name=itemView.findViewById(R.id.capital_name);
            languages=itemView.findViewById(R.id.languages);
            flag_icon=itemView.findViewById(R.id.flag_icon)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View =
            LayoutInflater.from(activity.baseContext).inflate(R.layout.country_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val country= countryList[position]
        holder.country_name.text= country.name
        holder.capital_name.text= country.capital
        holder.population_count.text= country.population.toString()
        holder.region_name.text= country.region
        holder.sub_region_name.text= country.subregion

        var languages=""
        for(language in country.languages)
            languages+="${language.name}, "
        holder.languages.text= languages

        SvgLoader.pluck()
                .with(activity)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(country.flag, holder.flag_icon);
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}