package miguel.insua.loveArt.modules.lists


import android.view.View
import miguel.insua.loveArt.R
import miguel.insua.loveArt.databinding.FragmentExampleBinding
import miguel.insua.loveArt.databinding.FragmentHomeBinding
import miguel.insua.loveArt.databinding.FragmentListsBinding
import miguel.insua.loveArt.modules.base.BaseFragment


class ListsFragment : BaseFragment<ListsViewModel, FragmentListsBinding>(
    ListsViewModel::class.java
) {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_lists
    }

    override fun viewCreated(view: View?) {
        mBinding.viewModel = viewModel
    }
}
