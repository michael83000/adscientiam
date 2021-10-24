package com.project.adscientiamtest.customview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.project.adscientiamtest.mainactivity.MainActivityViewModel
import com.project.adscientiamtest.modele.Square
import timber.log.Timber

class SquareView (context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private var dX : Float = 0.0f
    private var dY : Float = 0.0f
    private var centralPointX : Float = 0.0f
    private var centralPointY : Float = 0.0f

        init {
            this.setOnTouchListener {  view, motionEvent ->
                view.performClick()
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        dX = view.x - motionEvent.rawX
                        dY = view.y - motionEvent.rawY
                    }
                    MotionEvent.ACTION_MOVE -> {
                        with(view) {
                            animate()
                                    .x(motionEvent.rawX + dX)
                                    .y(motionEvent.rawY + dY)
                                    .setDuration(0)
                                    .start()
                            centralPointX = view.x + view.width / 2
                            centralPointY = view.y + view.height / 2
                        }
                    }
                    MotionEvent.ACTION_UP -> {
                        Timber.i("ACTION UP")
                        Timber.i("squareview $centralPointX, $centralPointY")
                        val viewModel = MainActivityViewModel()
                        val square = Square(0, centralPointX, centralPointY, System.currentTimeMillis())
                        viewModel.insert(square)


                    }

                }
                true
            }
        }

    override fun performClick(): Boolean {
        return super.performClick()
    }
   
}