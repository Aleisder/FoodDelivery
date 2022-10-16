package com.example.fooddelivery.view.screens.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.data.Burger
import kotlin.random.Random

class BurgerAdapter(
    private val burgers: List<Burger>,
) : RecyclerView.Adapter<BurgerAdapter.BurgerViewHolder>() {
    class BurgerViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvBurgerName)
        val description: TextView = view.findViewById(R.id.tvBurgerDescription)
        val cost: Button = view.findViewById(R.id.btnBuy)
        val picture: ImageView = view.findViewById(R.id.ivBurgerPicture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurgerViewHolder {
        val adapterLayout = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.burger_list_item,
                parent,
                false
            )
        return BurgerViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: BurgerViewHolder, position: Int) {
        val burger = burgers[position]
        holder.name.text = burger.name
        holder.description.text = burger.description
        holder.cost.text = "от " + Random.nextInt(200, 601) + " р"
        holder.picture.setImageResource(BurgerPictureUtil.pics[Random.nextInt(0, BurgerPictureUtil.pics.size)])
    }

    override fun getItemCount() = burgers.size
}