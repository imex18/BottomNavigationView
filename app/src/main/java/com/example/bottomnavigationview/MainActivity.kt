package com.example.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.view.get
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = Home()
        val workFragment = Work()
        val personFragment = Person()

        setFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.home -> setFragment(homeFragment)
                R.id.work -> setFragment(workFragment)
                R.id.person -> setFragment(personFragment)
            }
            true
        }

        bottomNavigationView.getOrCreateBadge(R.id.work).apply {
            number = 10 // in  real project this would be set dynamically based on the number of unread messages or assigned tasks etc.
            isVisible = true
        }
    }



    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}