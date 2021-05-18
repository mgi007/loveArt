package miguel.insua.loveArt.modules.home


import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import miguel.insua.loveArt.R
import miguel.insua.loveArt.databinding.FragmentHomeBinding
import miguel.insua.loveArt.modules.base.BaseFragment
import miguel.insua.loveArt.modules.start.StartFragment
import org.jetbrains.anko.attr
import org.jetbrains.anko.internals.AnkoInternals.createAnkoContext


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    HomeViewModel::class.java
) {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun viewCreated(view: View?) {
        mBinding.viewModel = viewModel
        initHomeAdapter()
        viewModel.refreshData()
    }

    private fun initHomeAdapter() {
        val layoutManager = GridLayoutManager(context, 1)
        recycler_view.layoutManager = layoutManager
        val appContext = requireContext().applicationContext
        recycler_view.adapter = HomeAdapter(appContext)
        viewModel.adapter = recycler_view.adapter as HomeAdapter
    }

    private fun showToast(text: String) {
        Toast.makeText(activity?.applicationContext, text, Toast.LENGTH_LONG).show()
    }

}
