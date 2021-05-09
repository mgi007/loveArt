package miguel.insua.loveArt.modules.home


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.little_item.view.*
import miguel.insua.loveArt.R
import miguel.insua.loveArt.model.Media


class HomeAdapter(private val context: Context): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var dataList = mutableListOf<Media>()

    fun setListData(data: MutableList<Media>) {
        dataList = data
    }

    inner class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindView(media: Media) {
            Glide.with(context).load(media.imageUrl).into(itemView.item_image)
            itemView.item_tittle.text = media.tittle
            itemView.item_director.text = media.director
            itemView.item_genre.text = media.genre
            itemView.item_year.text = media.year.toString()
            itemView.item_rating.rating = media.rating.toFloat()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.little_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val media: Media = dataList[position]
        holder.bindView(media)
    }

    override fun getItemCount(): Int {
        return if (dataList.size > 0) {
            dataList.size
        } else {
            0
        }
    }
}