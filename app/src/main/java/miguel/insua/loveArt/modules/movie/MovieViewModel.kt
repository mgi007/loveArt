package miguel.insua.loveArt.modules.movie

import android.app.Application
import miguel.insua.loveArt.application.App
import miguel.insua.loveArt.modules.base.BaseViewModel

class MovieViewModel(app: Application) : BaseViewModel(app) {

    lateinit var back: () -> Unit

    init {
        (app as? App)?.component?.inject(this)
    }
}