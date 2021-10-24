package com.project.adscientiamtest.datacollected

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.project.adscientiamtest.R
import com.project.adscientiamtest.modele.Square
import com.project.adscientiamtest.customview.SquareView
import java.text.SimpleDateFormat
import java.util.*

class DataCollectedAdapter(private val squares : List<Square>) : RecyclerView.Adapter<DataCollectedAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val squareView = itemView.findViewById<SquareView>(R.id.square)!!
        val cardView = itemView.findViewById<CardView>(R.id.cardView)!!
        val date = itemView.findViewById<TextView>(R.id.date)!!
        val centralPointX = itemView.findViewById<TextView>(R.id.centralPointX)!!
        val centralPointY = itemView.findViewById<TextView>(R.id.centralPointY)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_data, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val square = squares[position]
        with(holder) {
            squareView.setOnTouchListener(null)
            date.text = cardView.context.getString(R.string.string_date, convertLongToTime(square.date))
            centralPointX.text = cardView.context.getString(R.string.string_central_point_X, square.x)
            centralPointY.text = cardView.context.getString(R.string.string_central_point_Y, square.y)
        }
    }

    override fun getItemViewType(position: Int): Int = position

    override fun getItemCount(): Int = squares.size

    private fun convertLongToTime(date: Long) : String {
        val date = Date(date)
        val format = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.FRANCE)
        return format.format(date)
    }
}
