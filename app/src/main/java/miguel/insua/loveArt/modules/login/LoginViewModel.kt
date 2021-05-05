package miguel.insua.loveArt.modules.login

import android.app.Application
import miguel.insua.loveArt.application.App
import miguel.insua.loveArt.modules.base.BaseViewModel

class LoginViewModel(app: Application) : BaseViewModel(app) {

    lateinit var ejemplo: () -> Unit

    lateinit var back: () -> Unit


    init {
        (app as? App)?.component?.inject(this)
    }

}