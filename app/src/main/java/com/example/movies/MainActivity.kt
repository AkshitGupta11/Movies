package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.model.movies

class MainActivity : AppCompatActivity(){

    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMoviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        popularMovies = findViewById(R.id.popular_movies)
        popularMovies.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false

        )



        popularMoviesAdapter =
            MoviesAdapter(listOf(), this)
        popularMovies.adapter = popularMoviesAdapter

        MovieRepository.getPopularMovies(
            onSuccess = ::onPopularMoviesFetched,
            onError = ::onError
        )

    }

    private fun onPopularMoviesFetched(movies: List<movies>) {
        popularMoviesAdapter.updateMovies(movies)
    }



    private fun onError() {
        Toast.makeText(this,"No internet connection", Toast.LENGTH_SHORT).show()
    }


}

