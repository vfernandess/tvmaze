package com.voidx.common.domain.mapper.impl

import com.voidx.common.data.Image
import com.voidx.common.domain.mapper.ImageDomainMapper
import com.voidx.common.domain.model.ImageDTO

internal class ImageDomainMapperImpl: ImageDomainMapper {

    override fun map(from: Image): ImageDTO {
        return ImageDTO().apply {
            medium = from.medium
            original = from.original
        }
    }
}