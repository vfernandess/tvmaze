package com.voidx.core.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface Navigator {

    fun navigateTo(fragment: Fragment)

    fun goBack()

    fun getSupportFragmentManager(): FragmentManager
}