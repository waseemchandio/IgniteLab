package com.example.ignetilabtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.ignetilabtest.databinding.ActivityMainBinding
import com.example.ignetilabtest.fragments.favFragment.TodoListFragment
import com.example.ignetilabtest.fragments.homeFragment.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var fragment = HomeFragment()
        loadFragment(fragment)

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuHome -> {
                    // Respond to navigation item 1 click
                    var fragment = HomeFragment()
                    loadFragment(fragment)

                    true
                }
                R.id.menuFav -> {
                    // Respond to navigation item 2 click
                    var fragment = TodoListFragment()
                    loadFragment(fragment)
                    true
                }
                else -> {
                    false
                }
            }
        }


    }//class

    override fun onBackPressed() {
        closeApp();
    }

    private fun closeApp() {
        val dialogBuilder = AlertDialog.Builder(this)
        // set message of alert dialog
        dialogBuilder.setMessage("Do you want to close this application?")
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton("ok") { _, _ ->
                finish()
                super.onBackPressed()
            }
            // negative button text and action
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Igneti")
        // show alert dialog
        alert.show()

    }


    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainContainer, fragment)
        transaction.commit()
    }
}