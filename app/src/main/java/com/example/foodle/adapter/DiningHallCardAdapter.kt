package com.example.foodle.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodle.FoodDishActivity
import com.example.foodle.R
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import com.example.foodle.data.DataSource
import com.example.foodle.model.FoodData
import com.example.foodle.overview.OverviewViewModel
import com.google.android.material.card.MaterialCardView

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DiningHallCardAdapter(
    private val context: Context?,
    private val layout: Int,
    private val diningHall: String,
    private val mealType: String,
    private val meals: List<FoodData>
): ListAdapter<FoodData, DiningHallCardAdapter.FoodCardViewHolder>(DiffCallback) {


    // Initialize the data using the List found in data/DataSource
    private val data = meals

    /**
     * Initialize view elements
     */
    class FoodCardViewHolder(val view: View?): RecyclerView.ViewHolder(view!!) {
        // Declare and initialize the fruit name
        val dishName: TextView = view!!.findViewById(R.id.food_name)
        // Declare and initialize the fruit color
        val dishAllergens: TextView = view!!.findViewById(R.id.food_allergen)
//        // Declare and initialize the fruit's common dishes
//        val fruitDishes: TextView = view!!.findViewById(R.id.fruit_dishes)
        val card = view?.findViewById<CardView>(R.id.dining_hall_card)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<FoodData>() {

        override fun areItemsTheSame(oldItem: FoodData, newItem: FoodData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: FoodData, newItem: FoodData): Boolean {
            return oldItem.category == newItem.category && oldItem.link == newItem.link
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.dining_hall_food_item, parent, false)

        return FoodCardViewHolder(adapterLayout)
    }

    // Returns the size of the data set
    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: FoodCardViewHolder, position: Int) {
        val resources = context?.resources

        // Get the data at the current position
        val item = getItem(position)

        val context = holder.view?.context
        holder.card?.setOnClickListener {
            val intent = Intent(context, FoodDishActivity::class.java)
            context?.startActivity(intent)
        }

        // Set the image resource for the current fruit
//        holder.fruitImage.setImageResource(item.imageResourceId)
        // Set the text for the current dish's name
        holder.dishName.text = item.name
        // Set the text for the current fruit's color
        holder.dishAllergens.text = item.category
        // Set the text for the current fruit's common dishes
//        resources?.getString(R.string.fruit_taste, item.dishes).also { holder.fruitDishes.text = it }
    }
}
