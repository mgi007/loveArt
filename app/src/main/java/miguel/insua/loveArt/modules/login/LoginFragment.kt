package miguel.insua.loveArt.modules.login


import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_login.*
import miguel.insua.loveArt.R
import miguel.insua.loveArt.databinding.FragmentLoginBinding
import miguel.insua.loveArt.modules.base.BaseFragment
import miguel.insua.loveArt.modules.home.HomeActivity
import miguel.insua.loveArt.modules.home.HomeFragment
import miguel.insua.loveArt.modules.start.StartFragment


class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>(
    LoginViewModel::class.java
) {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_login
    }

    override fun viewCreated(view: View?) {
        mBinding.viewModel = viewModel
        viewModel.ejemplo = ::ejemplo
        viewModel.back = ::back
    }


    private fun ejemplo() {
        val ok = loginOk()
        if (ok) {
            val intent = Intent(activity?.applicationContext, HomeActivity::class.java)
            navigator.navigateToActivity(intent, Bundle())
        }
    }

    private fun back() {
        navigator.navigate(StartFragment(), false, StartFragment().LOG_TAG, container = R.id.fragmentContainerMain)
    }

    private fun loginOk(): Boolean {
        return true
    }

}
