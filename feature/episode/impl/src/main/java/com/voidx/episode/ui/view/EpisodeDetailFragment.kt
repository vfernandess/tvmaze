package com.voidx.episode.ui.view

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.voidx.episode.domain.model.EpisodeDTO
import com.voidx.episode.impl.R
import com.voidx.episode.impl.databinding.FragmentEpisodeDetailBinding

private const val EXTRA_EPISODE = "extra-episode"

class EpisodeDetailFragment: BottomSheetDialogFragment() {

    private lateinit var binding: FragmentEpisodeDetailBinding

    @SuppressLint("NewApi")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        bottomSheetDialog.setOnShowListener {
            val height = Resources.getSystem().displayMetrics.heightPixels * 0.85

            bottomSheetDialog.behavior.skipCollapsed = true
            bottomSheetDialog.behavior.peekHeight = height.toInt()
            bottomSheetDialog.behavior.setState(BottomSheetBehavior.STATE_EXPANDED)
        }

        return bottomSheetDialog
    }

    override fun getTheme() = R.style.CustomBottomSheetDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodeDetailBinding.inflate(inflater, container, false)

        binding.episode = arguments?.getParcelable(EXTRA_EPISODE)
        binding.close.setOnClickListener { dismiss() }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val height = Resources.getSystem().displayMetrics.heightPixels * 0.85

        binding.root.layoutParams?.height = height.toInt()
        binding.root.requestLayout()
    }

    companion object {

        fun newInstance(episode: EpisodeDTO): DialogFragment {
            return EpisodeDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_EPISODE, episode)
                }
            }
        }
    }
}