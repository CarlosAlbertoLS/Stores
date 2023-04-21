package com.sonder.tiendas.ui.listStores

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sonder.tiendas.R
import com.sonder.tiendas.databinding.ActivitySignInBinding
import com.sonder.tiendas.databinding.ActivityStoresBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoresActivity : AppCompatActivity() {
    companion object {
        fun createStores(context: Context) = Intent(context, StoresActivity::class.java)
    }
    private lateinit var binding: ActivityStoresBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoresBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomNavView= findViewById<BottomNavigationView>(R.id.bottomNavView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        bottomNavView.setupWithNavController(navController)
    }
}