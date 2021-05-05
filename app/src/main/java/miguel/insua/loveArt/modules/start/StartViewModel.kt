package miguel.insua.loveArt.modules.start

import android.app.Application
import miguel.insua.loveArt.application.App
import miguel.insua.loveArt.modules.base.BaseViewModel

class StartViewModel(app: Application) : BaseViewModel(app) {

    lateinit var login: () -> Unit

    lateinit var email: () -> Unit

    lateinit var facebook: () -> Unit

    lateinit var tweeter: () -> Unit

    init {
        (app as? App)?.component?.inject(this)
    }
}