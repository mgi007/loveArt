package miguel.insua.loveArt.modules.home

import android.app.Application
import androidx.recyclerview.widget.RecyclerView
import miguel.insua.loveArt.application.App
import miguel.insua.loveArt.model.Media
import miguel.insua.loveArt.modules.base.BaseViewModel

class HomeViewModel(app: Application) : BaseViewModel(app) {

    init {
        (app as? App)?.component?.inject(this)
    }

    lateinit var adapter: HomeAdapter

    fun refreshData() {
        val list: MutableList<Media> = mutableListOf<Media>()
        val media1: Media = Media("Control", "Daniel Simmons","Ficción","https://areajugones.sport.es/wp-content/uploads/2019/03/Control-nueva-car%C3%A1tula.png.webp", 3.5,2010)
        val media2: Media = Media("Control", "Daniel Simmons","Ficción","https://areajugones.sport.es/wp-content/uploads/2019/03/Control-nueva-car%C3%A1tula.png.webp", 3.5,2010)
        val media3: Media = Media("Control", "Daniel Simmons","Ficción","https://areajugones.sport.es/wp-content/uploads/2019/03/Control-nueva-car%C3%A1tula.png.webp", 3.5,2010)
        val media4: Media = Media("Control", "Daniel Simmons","Ficción","https://areajugones.sport.es/wp-content/uploads/2019/03/Control-nueva-car%C3%A1tula.png.webp", 3.5,2010)
        val media5: Media = Media("Control", "Daniel Simmons","Ficción","https://areajugones.sport.es/wp-content/uploads/2019/03/Control-nueva-car%C3%A1tula.png.webp", 3.5,2010)
        val media6: Media = Media("Control", "Daniel Simmons","Ficción","https://areajugones.sport.es/wp-content/uploads/2019/03/Control-nueva-car%C3%A1tula.png.webp", 3.5,2010)
        val media7: Media = Media("Control", "Daniel Simmons","Ficción","https://areajugones.sport.es/wp-content/uploads/2019/03/Control-nueva-car%C3%A1tula.png.webp", 3.5,2010)
        list.add(media1)
        list.add(media2)
        list.add(media3)
        list.add(media4)
        list.add(media5)
        list.add(media6)
        list.add(media7)
        adapter.setListData(list)
        adapter.notifyDataSetChanged()
    }

}