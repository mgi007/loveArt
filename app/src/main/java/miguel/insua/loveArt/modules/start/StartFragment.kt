package miguel.insua.loveArt.modules.start


import android.view.View
import miguel.insua.loveArt.R
import miguel.insua.loveArt.databinding.FragmentStartBinding
import miguel.insua.loveArt.modules.base.BaseFragment
import miguel.insua.loveArt.modules.login.LoginFragment


class StartFragment : BaseFragment<StartViewModel, FragmentStartBinding>(
    StartViewModel::class.java
) {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_start
    }

    override fun viewCreated(view: View?) {
        mBinding.viewModel = viewModel
        viewModel.login = ::login
        viewModel.email = ::email
        viewModel.facebook = ::facebook
        viewModel.tweeter = ::tweeter
    }

    private fun login() {
        navigator.navigate(LoginFragment(), false, LoginFragment().LOG_TAG, container = R.id.fragmentContainerMain)
    }

    private fun email() {

    }

    private fun facebook() {

    }

    private fun tweeter() {

    }
}
