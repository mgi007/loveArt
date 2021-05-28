package miguel.insua.loveArt.modules.home


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.internal.ContextUtils
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import miguel.insua.loveArt.R
import miguel.insua.loveArt.api.TMDbService
import miguel.insua.loveArt.databinding.FragmentHomeBinding
import miguel.insua.loveArt.model.Media
import miguel.insua.loveArt.model.MediaResponse
import miguel.insua.loveArt.modules.base.BaseFragment
import miguel.insua.loveArt.modules.lists.ListAdapter
import miguel.insua.loveArt.modules.login.LoginFragment
import miguel.insua.loveArt.modules.movie.MovieFragment
import miguel.insua.loveArt.modules.start.StartFragment
import org.jetbrains.anko.attr
import org.jetbrains.anko.internals.AnkoInternals.createAnkoContext
import retrofit2.Response


class HomeFragment : HomeAdapter.ItemOnClickListener, BaseFragment<HomeViewModel, FragmentHomeBinding>(
    HomeViewModel::class.java
) {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun viewCreated(view: View?) {
        mBinding.viewModel = viewModel
        val spinnerList = resources.getStringArray(R.array.select_movie_query)
        val spinnerAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            requireContext().applicationContext,
            R.array.select_movie_query,
            android.R.layout.simple_spinner_item
        )
        select_movie_query.adapter = spinnerAdapter
        spinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        select_movie_query.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selectMovieQuery(spinnerList[position])
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
        }
        initHomeAdapter()
        getMovies("popular")
    }

    private fun initHomeAdapter() {
        val layoutManager = GridLayoutManager(context, 1)
        recycler_view.layoutManager = layoutManager
        recycler_view.addItemDecoration(DividerItemDecoration(
            requireContext().applicationContext,
            layoutManager.orientation)
        )
        recycler_view.adapter = HomeAdapter(requireContext().applicationContext, this)
        viewModel.adapter = recycler_view.adapter as HomeAdapter
    }

    private fun getMovies(query: String) {
        var numPage: Int = 1
        val completQuery: String = "$query?api_key=5451f06f86322e090841b4c2ebab2b7d&page=$numPage"
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<MediaResponse> =
                viewModel.getRetrofit().create(TMDbService::class.java).getMovies("$completQuery")
            val mediaResponse: MediaResponse? = call.body()
            activity?.runOnUiThread(Runnable {
                if (call.isSuccessful) {
                    // Show RecyclerView
                    val medias: List<Media>? = mediaResponse?.results
                    viewModel.list.clear()
                    if (medias != null) {
                        viewModel.list.addAll(medias)
                    }
                    viewModel.refreshData()



                } else {
                    showToast(R.string.error_loading_popular.toString())
                }
            })
        }
    }

    private fun selectMovieQuery(searchOption: String) {
        val optionsArray = resources.getStringArray(R.array.select_movie_query)
        when (searchOption) {
            optionsArray[0] -> {
                getMovies("popular")
            }
            optionsArray[1] -> {
                getMovies("now_playing")
            }
            optionsArray[2] -> {
                getMovies("top_rated")
            }
            optionsArray[3] -> {
                getMovies("upcoming")
            }
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(activity?.applicationContext, text, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(media: Media) {
        showToast(media.tittle.toString())
        navigator.navigate(MovieFragment(), false, MovieFragment().LOG_TAG, container = R.id.fragmentContainerHome)
    }

}
