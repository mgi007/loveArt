package miguel.insua.loveArt.modules.home

import android.os.Bundle
import miguel.insua.loveArt.R
import miguel.insua.loveArt.databinding.ActivityHomeBinding
import miguel.insua.loveArt.modules.base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>(
    HomeViewModel::class.java
) {
    override fun getLayoutRes(): Int {
        return R.layout.activity_home
    }

    override fun initViewModel(viewModel: HomeViewModel) {
        binding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator.addFragment(HomeFragment(), R.id.fragmentContainerHome)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}
