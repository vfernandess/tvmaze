package com.voidx.search.ui.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.voidx.search.impl.R
import com.voidx.search.impl.databinding.FragmentSearchBinding
import com.voidx.search.navigator.SearchNavigator
import com.voidx.search.ui.presentation.SearchShowState
import com.voidx.search.ui.presentation.SearchShowViewModel
import com.voidx.search.ui.view.adapter.SearchShowDelegate
import com.voidx.shows.domain.model.ShowDTO
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

private const val EXTRA_QUERY = "extra-query"

class SearchFragment : Fragment(), AndroidScopeComponent, SearchView.OnQueryTextListener {

    override val scope: Scope by fragmentScope()

    private lateinit var binding: FragmentSearchBinding

    private val searchViewModel: SearchShowViewModel by viewModel()

    private val navigator: SearchNavigator by inject()

    private val adapter by lazy {
        SearchShowDelegate(::handleShowClicked).adapter
    }

    private var query: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        query = arguments?.getString(EXTRA_QUERY)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.adapter = adapter

        binding.search.setQuery(query, false)
        binding.search.setOnQueryTextListener(this)

        searchViewModel.state().observe(viewLifecycleOwner) {
            when (it) {
                is SearchShowState.Error ->
                    handleError()

                is SearchShowState.LoadItems ->
                    loadItems(it.items)

                SearchShowState.Loading ->
                    handleLoading()
            }
        }

        searchViewModel.load(query)
    }


    private fun handleLoading() {
        binding.loading.visibility = View.VISIBLE
        binding.list.visibility = View.GONE
    }

    private fun loadItems(items: List<ShowDTO>) {
        binding.loading.visibility = View.GONE
        binding.list.visibility = View.VISIBLE

        adapter.items = items
        adapter.notifyDataSetChanged()
    }

    private fun handleError() {
        Snackbar
            .make(binding.root, R.string.general_error, Snackbar.LENGTH_LONG)
            .show()
    }

    private fun handleShowClicked(showDTO: ShowDTO?) {
        showDTO?.let {
            navigator.showDetail(it.id)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        this.query = query
        searchViewModel.load(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }

    companion object {

        fun newInstance(query: String?): Fragment {
            return SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_QUERY, query)
                }
            }
        }
    }
}