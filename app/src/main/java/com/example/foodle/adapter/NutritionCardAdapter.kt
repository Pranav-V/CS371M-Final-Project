package com.example.foodle.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodle.FoodDishActivity
import com.example.foodle.R
import com.example.foodle.data.DataSource
import com.google.android.material.card.MaterialCardView

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class NutritionCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<NutritionCardAdapter.NutritionCardViewHolder>() {

    // Initialize the data using the List found in data/DataSource
    // Hard coded cinnamon roll nutrition
    private val data = DataSource.foods[0].link

    /**
     * Initialize view elements
     */
    class NutritionCardViewHolder(val view: View?): RecyclerView.ViewHolder(view!!) {
        // Declare and initialize the fruit name
        val nutrition: TextView = view!!.findViewById(R.id.food_nutrition)
        val card = view?.findViewById<MaterialCardView>(R.id.nutrition_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionCardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.nutrition_item, parent, false)

        return NutritionCardViewHolder(adapterLayout)
    }

    // Returns the size of the data set
    override fun getItemCount(): Int = 0

    override fun onBindViewHolder(holder: NutritionCardViewHolder, position: Int) {
        val resources = context?.resources

        // Get the data at the current position
        val item = data[position]

        val context = holder.view?.context
        // Perhaps make it open a Google Search query?
//        holder.card?.setOnClickListener {
//            val intent = Intent(context, FoodDishActivity::class.java)
//            context?.startActivity(intent)
//        }

        // Set the image resource for the current fruit
//        holder.fruitImage.setImageResource(item.imageResourceId)
        // Set the text for the current dish's name
        holder.nutrition.text = "updated"
    }
}
