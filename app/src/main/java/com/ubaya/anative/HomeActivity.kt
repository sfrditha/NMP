package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.ubaya.anative.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle
    private val fragments: ArrayList<Fragment> = ArrayList()
    var user_id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the drawer and the toolbar
        setSupportActionBar(binding.toolbarHome)
        supportActionBar?.title = "Native"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Initialize the drawer toggle
        drawerToggle = ActionBarDrawerToggle(this, binding.drawerLayout,
            binding.toolbarHome, R.string.app_name, R.string.app_name)
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        // Handle menu item selection
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemApplyTeam -> {
//                    Snackbar.make(this,binding.root, "Apply team", Snackbar.LENGTH_SHORT).show()
                    joinProposal()
                }
                R.id.itemLogOut -> {
//                    Snackbar.make(this,binding.root, "Log Out", Snackbar.LENGTH_SHORT).show()
                    logOut()
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Handle fragments
        user_id = intent.getIntExtra("user_id", 0)
        fragments.add(WhatWePlayFragment())
        fragments.add(WhoWeAreFragment())
        fragments.add(ScheduleFragment())

        binding.viewPager.adapter = FragAdapter(this, fragments)

        val idFragment = intent.getIntExtra("home_index", 0)

        binding.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNav.menu.getItem(position).isChecked = true
            }
        })

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itemWhatWePlay -> binding.viewPager.currentItem = 0
                R.id.itemWhoWeAre -> binding.viewPager.currentItem = 1
                R.id.itemSchedule -> binding.viewPager.currentItem = 2
                else -> false
            }
            true
        }

        // Set the initial page based on intent extra
        binding.viewPager.setCurrentItem(idFragment, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle the drawer toggle
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun joinProposal() {
        val intent = Intent(this, ProposalActivity::class.java)
        intent.putExtra("user_id", user_id)
        startActivity(intent)
    }

    private  fun logOut(){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}
