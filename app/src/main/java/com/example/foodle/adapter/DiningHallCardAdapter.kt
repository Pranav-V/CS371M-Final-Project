package com.example.foodle.adapter

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodle.R
import androidx.recyclerview.widget.DiffUtil
import com.example.foodle.model.FoodData

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
        val foodName: TextView = view!!.findViewById(R.id.food_name)
        // Declare and initialize the fruit color
        val foodCategory: TextView = view!!.findViewById(R.id.food_category)
        val redirect: TextView = view!!.findViewById(R.id.nutrition_redirect_text)
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
        val item = data[position]

        val context = holder.view?.context
        holder.card?.setOnClickListener {
            val card: CardView = holder.card
            quickScale(card)
            val webIntent: Intent = Uri.parse(item.link).let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }
            context?.startActivity(webIntent)
        }


        holder.foodName.text = item.name
        holder.foodName.contentDescription = item.name
        holder.foodCategory.text = item.category
        holder.foodCategory.contentDescription = item.category.replace("-", "")
        holder.redirect.contentDescription = "View Nutritional Information on the Web."

        if (item.name == "Food Not Served") {
            holder.redirect.visibility = View.INVISIBLE
        }
    }

    private fun quickScale(item: CardView) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, -0.1f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, -0.1f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(item, scaleX, scaleY)
        animator.repeatCount = 1
        animator.duration = 600
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    private fun test() {
        Log.d("DataTest", "Hello.")
    }
}
