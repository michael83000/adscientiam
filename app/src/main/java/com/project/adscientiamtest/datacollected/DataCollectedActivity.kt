package com.project.adscientiamtest.datacollected

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.adscientiamtest.R
import com.project.adscientiamtest.modele.Square
import kotlinx.android.synthetic.main.activity_data_collected.*
import timber.log.Timber

class DataCollectedActivity : AppCompatActivity() {

    private lateinit var dataCollectedAdapter : DataCollectedAdapter
    private lateinit var squares : MutableList<Square>
    private lateinit var viewModel: DataCollectedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_collected)

        viewModel = ViewModelProvider(this).get(DataCollectedViewModel::class.java)
        squares = mutableListOf()


        viewModel.squares.observe(this, Observer { listSquare -> updateUi(listSquare) })

        dataCollectedAdapter = DataCollectedAdapter(squares)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@DataCollectedActivity)
            adapter = dataCollectedAdapter
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_data_collected, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete_all_data -> showDeleteDialog()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showDeleteDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {

            setTitle(R.string.delete_title_dialog)
            setMessage(R.string.delete_text_alert_dialog)
            setPositiveButton(getString(R.string.string_positive_dialog)) { _, _ ->
               viewModel.deleteAllDatas()
            }
            setNegativeButton(getString(R.string.string_negative_dialog)) { dialog, _ ->
                dialog.dismiss()
            }
        }.create().show()
    }

    private fun updateUi(listSquare: List<Square>) {
        Timber.i("liste square $listSquare, size: ${listSquare.size}")
        squares.clear()
        squares.addAll(listSquare)
        dataCollectedAdapter.notifyDataSetChanged()
    }
}