package com.voidx.showdetail.ui.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.voidx.core.view.binding.load
import com.voidx.episode.domain.model.EpisodeDTO
import com.voidx.showdetail.domain.model.ShowDetail
import com.voidx.showdetail.impl.R
import com.voidx.showdetail.impl.databinding.FragmentShowDetailBinding
import com.voidx.showdetail.navigator.ShowDetailNavigator
import com.voidx.showdetail.ui.detail.presentation.ShowDetailState
import com.voidx.showdetail.ui.detail.presentation.ShowDetailViewModel
import com.voidx.showdetail.ui.detail.view.adapter.ShowDetailDelegate
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

private const val EXTRA_SHOW_ID = "extra-show-id"

class ShowDetailFragment : Fragment(), AndroidScopeComponent {
    override val scope: Scope by fragmentScope()

    private lateinit var binding: FragmentShowDetailBinding
    private val showDetailViewModel: ShowDetailViewModel by viewModel()
    private val navigator: ShowDetailNavigator by inject()

    private val showID by lazy {
        arguments?.getInt(EXTRA_SHOW_ID, -1) ?: -1
    }

    private val adapter by lazy {
        ShowDetailDelegate(::handleEpisodeClick).adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowDetailBinding.inflate(inflater, container, false)

        binding.toolbar.setNavigationOnClickListener {
            navigator.goBack()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDetailViewModel.state().observe(viewLifecycleOwner) {
            when (it) {
                is ShowDetailState.Error ->
                    handleError()

                is ShowDetailState.LoadItems ->
                    handleLoadItems(it.poster, it.list)

                is ShowDetailState.Loading ->
                    handleLoading()
            }
        }

        showDetailViewModel.load(showID)
    }

    private fun handleLoading() {
        binding.loading.visibility = VISIBLE
        binding.list.visibility = GONE
    }

    private fun handleLoadItems(poster: String?, list: List<ShowDetail>) {
        binding.loading.visibility = GONE
        binding.list.visibility = VISIBLE

        binding.list.adapter = adapter
        adapter.items = list
        adapter.notifyDataSetChanged()

        binding.poster.load(poster)
    }

    private fun handleError() {
        Snackbar.make(
            binding.root,
            R.string.general_error,
            Snackbar.LENGTH_INDEFINITE
        )
            .setAction(R.string.try_again) {
                showDetailViewModel.load(showID)
            }
            .show()
    }

    private fun handleEpisodeClick(episodeDTO: EpisodeDTO) {
        navigator.showEpisode(episodeDTO)
    }

    companion object {

        fun newInstance(showID: Int): Fragment {
            return ShowDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(EXTRA_SHOW_ID, showID)
                }
            }
        }
    }
}