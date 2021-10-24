package com.project.adscientiamtest.mainactivity

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.project.adscientiamtest.datacollected.DataCollectedActivity
import com.project.adscientiamtest.R
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)





        viewModel.square.observe(this, Observer { square ->
            if (square != null) {
                viewDraggable.viewTreeObserver.addOnGlobalLayoutListener {
                    viewDraggable.x = square.x - viewDraggable.width/2f
                    viewDraggable.y = square.y - viewDraggable.height/2f

                }

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.launch_data_collected_activity -> {
                launchDataCollectedActivity()
            }
            //Prise en charge du dark mode
            R.id.dark_mode -> {
                when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                    Configuration.UI_MODE_NIGHT_YES -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    Configuration.UI_MODE_NIGHT_NO -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                Timber.i("Click dark mode")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun launchDataCollectedActivity() {
        val intent = Intent(this, DataCollectedActivity::class.java)
        startActivity(intent)

    }
}