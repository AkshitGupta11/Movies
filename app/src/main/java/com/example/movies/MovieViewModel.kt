package com.example.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.model.movies

class MovieViewModel : ViewModel(){
    val selected = MutableLiveData<movies>()

    fun select(movie: movies){
        selected.value=movie
    }
}