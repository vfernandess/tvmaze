package com.voidx.common.di

import com.voidx.common.domain.mapper.ImageDomainMapper
import com.voidx.common.domain.mapper.impl.ImageDomainMapperImpl
import org.koin.dsl.module

val commonModule = module {

    factory<ImageDomainMapper> {
        ImageDomainMapperImpl()
    }
}