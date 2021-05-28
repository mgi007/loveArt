package miguel.insua.loveArt.modules.movie


import android.view.View
import miguel.insua.loveArt.R
import miguel.insua.loveArt.databinding.FragmentExampleBinding
import miguel.insua.loveArt.databinding.FragmentHomeBinding
import miguel.insua.loveArt.databinding.FragmentMovieBinding
import miguel.insua.loveArt.modules.base.BaseFragment
import miguel.insua.loveArt.modules.home.HomeFragment


class MovieFragment : BaseFragment<MovieViewModel, FragmentMovieBinding>(
    MovieViewModel::class.java
) {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_movie
    }

    override fun viewCreated(view: View?) {
        mBinding.viewModel = viewModel
        viewModel.back = ::back
    }

    private fun back() {
        navigator.navigate(HomeFragment(), false, HomeFragment().LOG_TAG, container = R.id.fragmentContainerHome)
    }
}
