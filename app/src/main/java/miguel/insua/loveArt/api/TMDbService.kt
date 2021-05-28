package miguel.insua.loveArt.api

import miguel.insua.loveArt.model.Media
import miguel.insua.loveArt.model.MediaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface TMDbService {

    @GET
    suspend fun getMovies(@Url query: String): Response<MediaResponse>

}