package com.example.shevtcov_lesson_4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class CustomView @JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint().apply {
        color = Color.RED
        style = Paint.Style.STROKE
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val h = (height/2).toFloat()
        val w = (width/2).toFloat()
        canvas?.drawLine(0f, 0f, h, w, paint)
    }
}