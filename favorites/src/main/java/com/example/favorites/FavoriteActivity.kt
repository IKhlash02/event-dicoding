package com.example.favorites

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstone1.R
import com.example.core.data.Resource
import com.example.core.ui.EventAdapter
import com.example.capstone1.databinding.ActivityFavoriteBinding
import com.example.capstone1.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityFavoriteBinding
    private  val favoriteViewModel: FavoriteViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFavoriteBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val factory = ViewModelFactory.getInstance(this)
//       favoriteViewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

        val eventAdapter = EventAdapter()
        eventAdapter.onItemClick= {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, it)
            startActivity(intent)
        }

        favoriteViewModel.event.observe(this) { event ->
            if (event != null) {
                when (event) {
                    is Resource.Loading -> showLoading(true)
                    is Resource.Success -> {
                        showLoading(false)
                        eventAdapter.setData(event.data)
                        eventAdapter.notifyDataSetChanged()

                    }

                    is Resource.Error -> {
                        showLoading(false)
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = event.message ?: getString(R.string.something_wrong)
                    }
                }
            }

        }

        with(binding.rvEvent) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = eventAdapter
        }


    }


    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}