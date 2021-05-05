package miguel.insua.loveArt.modules.home


import android.view.View
import miguel.insua.loveArt.R
import miguel.insua.loveArt.databinding.FragmentHomeBinding
import miguel.insua.loveArt.modules.base.BaseFragment


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    HomeViewModel::class.java
) {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun viewCreated(view: View?) {
        mBinding.viewModel = viewModel
    }
}
