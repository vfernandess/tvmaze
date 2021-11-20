package com.voidx.common.domain.mapper

import com.voidx.common.data.Image
import com.voidx.common.domain.model.ImageDTO

interface ImageDomainMapper {

    fun map(from: Image): ImageDTO
}