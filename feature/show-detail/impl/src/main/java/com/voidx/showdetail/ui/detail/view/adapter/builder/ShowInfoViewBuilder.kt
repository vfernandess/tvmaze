package com.voidx.showdetail.ui.detail.view.adapter.builder

import com.voidx.core.view.binding.adapterDelegateLayoutBinding
import com.voidx.showdetail.domain.model.ShowDetail
import com.voidx.showdetail.domain.model.ShowDetailDTO
import com.voidx.showdetail.impl.R
import com.voidx.showdetail.impl.databinding.ShowInfoViewBinding

object ShowInfoViewBuilder {

    fun build() =
        adapterDelegateLayoutBinding<ShowDetailDTO, ShowDetail, ShowInfoViewBinding>(layout = R.layout.show_info_view)
        {
            bind {
                binding.show = item
            }
        }
}