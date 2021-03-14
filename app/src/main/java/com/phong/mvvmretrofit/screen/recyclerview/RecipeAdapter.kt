package com.phong.mvvmretrofit.screen.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phong.mvvmretrofit.R
import com.phong.mvvmretrofit.data.model.Recipe

class RecipeAdapter(private val recipes: ArrayList<Recipe>, val onItemClicked: (Recipe) -> Unit) :
    RecyclerView.Adapter<RecipeViewHolder>() {

    fun addUsers(recipe: List<Recipe>) {
        this.recipes.apply {
            clear()
            addAll(recipe)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(itemView, onItemClicked)
    }

    override fun getItemCount() = recipes.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binData(recipes[position])
    }
}
