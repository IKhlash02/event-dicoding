package com.example.capstone1.detail

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.capstone1.R
import com.example.capstone1.core.domain.model.Event

import com.example.capstone1.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailBinding
    private  val detailViewModel: DetailViewModel by viewModels()

    private var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val detailEvent = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_DATA, Event::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DATA)
        }

//        val factory = ViewModelFactory.getInstance(this)
//        detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        detailEvent?.let {
            detailViewModel.getFavoriteEventById(it.id).observe(this) {
                showFavorite(it)
                Log.d("hasil1", isFavorite.toString())
                isFavorite = it
            }

            showDetailEvent(detailEvent = it)
        }


    }

    private fun showDetailEvent(detailEvent: Event) {

        Glide.with(this@DetailActivity)
            .load(detailEvent.mediaCover)
            .into(binding.ivCover)

        binding.title.text = detailEvent.name
        @Suppress("DEPRECATION")
        binding.description.setText(Html.fromHtml(detailEvent.description))
        binding.summary.text = detailEvent.summary


        binding.floatingActionButton.setOnClickListener {
            if (!isFavorite) {
                detailViewModel.insert(detailEvent)
                isFavorite = true
                showFavorite(isFavorite)
                showToast("Add to Favorite")
            } else {
                detailViewModel.delete(detailEvent)
                isFavorite = false
                showFavorite(isFavorite)
                showToast("Delete from Favorite")
            }
        }

    }

    private fun showFavorite(isFavorite: Boolean) {
        if (isFavorite) {
            binding.floatingActionButton.setImageResource(R.drawable.favorite)
        } else {
            binding.floatingActionButton.setImageResource(R.drawable.favorite_border)

        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}