package com.voidx.tvmaze

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.voidx.core.navigator.Navigator
import com.voidx.shows.navigator.ShowsNavigator
import com.voidx.tvmaze.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding

    private val showsNavigator: ShowsNavigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadKoinModules(module {
            factory<Navigator> { this@MainActivity }
        })

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showsNavigator.showHome()
    }

    override fun navigateTo(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, fragment)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun goBack() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        } else {
            onBackPressed()
        }
    }
}