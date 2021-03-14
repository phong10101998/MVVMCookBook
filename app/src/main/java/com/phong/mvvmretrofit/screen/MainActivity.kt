package com.phong.mvvmretrofit.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.phong.mvvmretrofit.utils.Status
import com.phong.mvvmretrofit.R
import com.phong.mvvmretrofit.data.model.Recipe
import com.phong.mvvmretrofit.screen.recyclerview.RecipeAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnButton.setOnClickListener {
            setUpViewModel()
            setUpUI()
            registerObservers()
        }

    }

    private fun setUpViewModel() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    private fun setUpUI() {
        adapter = RecipeAdapter(arrayListOf()) {
            Toast.makeText(this@MainActivity, it.title, Toast.LENGTH_LONG).show()
        }
        recyclerView.adapter = adapter
    }

    private fun registerObservers() {
        mainViewModel.getRecipe().observe(this, { userList ->
            userList?.let { it ->
                when (it.status) {
                    Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        it.data?.let { recipes ->
                            retrieveList(recipes.body()!!.recipes)
                        }
                    }
                    Status.ERROR -> {
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(recipes: List<Recipe>) {
        adapter.apply {
            addUsers(recipes)
            notifyDataSetChanged()
        }
    }

}
