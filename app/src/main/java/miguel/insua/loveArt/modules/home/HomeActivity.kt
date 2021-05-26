package miguel.insua.loveArt.modules.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.toolbar.*
import miguel.insua.loveArt.R
import miguel.insua.loveArt.databinding.ActivityHomeBinding
import miguel.insua.loveArt.modules.base.BaseActivity
import miguel.insua.loveArt.modules.lists.ListsFragment
import miguel.insua.loveArt.modules.main.MainActivity
import org.jetbrains.anko.email

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>(
    HomeViewModel::class.java
) {

    lateinit var uid: String

    var fragmentState: FragmentState = FragmentState.HOME

    override fun getLayoutRes(): Int {
        return R.layout.activity_home
    }

    override fun initViewModel(viewModel: HomeViewModel) {
        binding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uid = intent.extras?.getString("uid").toString()
        Toolbar().show(this, title = "Home", false)
        if (fragmentState == FragmentState.HOME) {
            navigator.addFragment(HomeFragment(), R.id.fragmentContainerHome)
        } else if (fragmentState == FragmentState.LISTS) {
            navigator.addFragment(ListsFragment(), R.id.fragmentContainerHome)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.my_lists) {
            goTo(FragmentState.LISTS)
        }

        if (item.itemId == R.id.go_to_home) {
            goTo(FragmentState.HOME)
        }

        if (item.itemId == R.id.log_out) {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, MainActivity::class.java)
            navigator.navigateToActivity(intent, Bundle())
        }

        return super.onOptionsItemSelected(item)
    }


    private fun goTo(fragmentToGo: FragmentState) {

        when (fragmentState) {
            FragmentState.HOME -> {
                toolbar.menu.removeItem(R.id.my_lists)
                toolbar.menu.removeItem(R.id.log_out)
            }
            FragmentState.LISTS -> {
                toolbar.menu.removeItem(R.id.go_to_home)
                toolbar.menu.removeItem(R.id.log_out)
            }
        }

        when (fragmentToGo) {
            FragmentState.HOME -> {
                menuInflater.inflate(R.menu.home_menu, toolbar.menu)
                navigator.navigate(HomeFragment(), false, HomeFragment().LOG_TAG, container = R.id.fragmentContainerHome)
                fragmentState = FragmentState.HOME
            }
            FragmentState.LISTS -> {
                menuInflater.inflate(R.menu.lists_menu, toolbar.menu)
                navigator.navigate(ListsFragment(), false, ListsFragment().LOG_TAG, container = R.id.fragmentContainerHome)
                fragmentState = FragmentState.LISTS
            }
        }

    }
}
