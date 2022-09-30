package com.twr.mangago

import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import android.widget.ProgressBar
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.color.DynamicColors
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.twr.mangago.HomeFragment
import com.google.android.material.navigation.NavigationBarView
import com.twr.mangago.RssNotificationFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        DynamicColors.applyToActivityIfAvailable(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationMenu)
        bottomNavigationView.setOnItemSelectedListener(navListener)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
        }
    }

    private val navListener = NavigationBarView.OnItemSelectedListener { item ->
        var selectedFragment: Fragment? = null
        when (item.itemId) {
            R.id.home -> selectedFragment = HomeFragment()
            R.id.rss -> selectedFragment = RssNotificationFragment()
        }
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            selectedFragment!!
        ).commit()
        true
    }
}