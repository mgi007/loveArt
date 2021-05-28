package miguel.insua.loveArt.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("id")
    @Expose
    val id: Int?,

    @SerializedName("title")
    @Expose
    val tittle: String?,

    @SerializedName("original_language")
    @Expose
    val og_language: String?,

    @SerializedName("poster_path")
    @Expose
    val imageUrl: String?,

    @SerializedName("vote_average")
    @Expose
    val rating: Double?,

    @SerializedName("vote_count")
    @Expose
    val vote_count: Int?,

    @SerializedName("release_date")
    @Expose
    val releaseDate: String?
    ) {}

