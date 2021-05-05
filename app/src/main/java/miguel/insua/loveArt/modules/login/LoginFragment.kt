package miguel.insua.loveArt.modules.login


import android.view.View
import kotlinx.android.synthetic.main.fragment_login.*
import miguel.insua.loveArt.R
import miguel.insua.loveArt.databinding.FragmentLoginBinding
import miguel.insua.loveArt.modules.base.BaseFragment
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
        navigator.navigate(HomeFragment(), false, HomeFragment().LOG_TAG, container = R.id.fragmentContainerMain)
    }

    private fun back() {
        navigator.navigate(StartFragment(), false, StartFragment().LOG_TAG, container = R.id.fragmentContainerMain)
    }

}
