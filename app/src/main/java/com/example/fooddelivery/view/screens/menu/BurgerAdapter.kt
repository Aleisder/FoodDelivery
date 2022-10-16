package com.example.fooddelivery.view.screens.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.data.Burger

class BurgerAdapter(
    private val burgers: List<Burger>,
) : RecyclerView.Adapter<BurgerAdapter.BurgerViewHolder>() {
    class BurgerViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val burgerName: TextView = view.findViewById(R.id.tvBurgerName)
        val burgerDescription: TextView = view.findViewById(R.id.tvBurgerDescription)
        val burgerPicture: ImageView = view.findViewById(R.id.ivBurgerPicture)
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
        holder.burgerName.text = burger.name
        holder.burgerDescription.text = burger.description
        holder.burgerPicture.setImageResource(R.drawable.burger)
    }

    override fun getItemCount() = burgers.size
}