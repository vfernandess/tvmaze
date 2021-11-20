package com.voidx.shows.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.voidx.core.view.EndlessRecyclerScrollListener
import com.voidx.shows.domain.model.ShowDTO
import com.voidx.shows.impl.R
import com.voidx.shows.impl.databinding.FragmentHomeShowsBinding
import com.voidx.shows.navigator.ShowsNavigator
import com.voidx.shows.ui.home.presentation.HomeShowsState
import com.voidx.shows.ui.home.presentation.HomeViewModel
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class HomeShowsFragment : Fragment(), AndroidScopeComponent {

    override val scope: Scope by fragmentScope()

    private val homeViewModel: HomeViewModel by viewModel()
    private val homeNavigator: ShowsNavigator by inject()

    private lateinit var binding: FragmentHomeShowsBinding
    private val homeShowsAdapter = HomeShowsAdapter(::handleItemClicked)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeShowsBinding.inflate(inflater, container, false)

        with(binding.list) {
            adapter = homeShowsAdapter
            addOnScrollListener(
                EndlessRecyclerScrollListener(
                    binding.list.layoutManager,
                    ::handleLoadMore
                )
            )
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.state().observe(viewLifecycleOwner) { state ->
            when (state) {
                is HomeShowsState.Error ->
                    handleError()

                is HomeShowsState.LoadItems ->
                    loadItems(state.items)

                HomeShowsState.Loading ->
                    handleLoading()
            }
        }

        homeViewModel.load()
    }

    private fun handleLoading() {
        binding.loading.visibility = VISIBLE
        binding.list.visibility = GONE
    }

    private fun loadItems(items: List<ShowDTO>) {
        binding.loading.visibility = GONE
        binding.list.visibility = VISIBLE

        homeShowsAdapter.addItems(items)
    }

    private fun handleError() {
        Snackbar
            .make(binding.root, R.string.general_error, Snackbar.LENGTH_LONG)
            .show()
    }

    private fun handleItemClicked(showDTO: ShowDTO?) {
        showDTO?.let {
            homeNavigator.showDetail(showID = it.id)
        }
    }

    private fun handleLoadMore(page: Int, count: Int) {
        homeViewModel.loadMore()
    }
}