package miguel.insua.loveArt.modules.siEmail

import android.app.Application
import miguel.insua.loveArt.application.App
import miguel.insua.loveArt.modules.base.BaseViewModel

class SiEmailViewModel(app: Application) : BaseViewModel(app) {

    lateinit var ejemplo: () -> Unit

    lateinit var back: () -> Unit

    init {
        (app as? App)?.component?.inject(this)
    }
}