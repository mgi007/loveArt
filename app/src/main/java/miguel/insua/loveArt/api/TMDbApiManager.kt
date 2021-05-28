package miguel.insua.loveArt.api

import android.app.Activity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import miguel.insua.loveArt.R
import miguel.insua.loveArt.model.Media
import miguel.insua.loveArt.model.MediaResponse
import miguel.insua.loveArt.modules.home.HomeFragment
import miguel.insua.loveArt.modules.home.HomeViewModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TMDbApiManager()  {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun requestMovies(query: String, numPage: Int): List<Media>? {
        val completQuery: String = "$query?api_key=5451f06f86322e090841b4c2ebab2b7d&page=$numPage"
        var movies: List<Media>? = null
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<MediaResponse> =
                getRetrofit().create(TMDbService::class.java).getMovies("$completQuery")
            val mediaResponse: MediaResponse? = call.body()
            if (call.isSuccessful) {
                movies = mediaResponse?.results
            }
        }
        return movies
    }

}

