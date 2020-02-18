package com.example.movies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.movies.model.movies
import kotlinx.android.synthetic.main.movie_item.view.*


class MoviesAdapter(
    private var movies: List<movies>,
    private var context: Context
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }
    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])


        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent)

        } }

    fun updateMovies(movies: List<movies>) {
        this.movies = movies
        notifyDataSetChanged()
    }



    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val poster: ImageView = itemView.findViewById(R.id.movie_item_poster)
        private val moviebudget = itemView.movie_title
        private val releasedate = itemView.release_date
        val id= itemView.book

        fun bind(movie: movies) {


            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${movie.backdrop_path}")
                .transform(CenterCrop())
                .into(poster)

            moviebudget.setText(movie.original_title)
            releasedate.setText(movie.release_date)
            //id.setText(movie.id)
        }

    }
}
