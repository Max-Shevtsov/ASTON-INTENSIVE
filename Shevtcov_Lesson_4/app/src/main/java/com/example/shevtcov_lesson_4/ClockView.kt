package com.example.shevtcov_lesson_4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.Path
import android.graphics.Rect
import android.icu.util.Calendar
import android.util.AttributeSet
import android.view.View
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin


class ClockView
@JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val path = Path()
    private val rect = Rect()
    private var scrHeight = height.toFloat()
    private var scrWidth = width.toFloat()
    private val scrPadding = 50f
    private var clockCentreX = 0f
    private var clockCentreY = 0f
    private var minimum = 0f
    private var clockRadius = 0f
    private var hourHandSize = 0f
    private var handSize = 0f
    private val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    private var isInit = false

    private lateinit var calendar: Calendar
    private var hour = 0
    private var minute = 0
    private var second = 0

    private var angle: Double = PI / 30 - PI / 2

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (!isInit) {
            init()
        }

        drawCircle(canvas)
        drawHands(canvas)
        postInvalidateDelayed(500)
    }

    private fun init() {
        scrHeight = height.toFloat()
        scrWidth = width.toFloat()
        clockCentreX = scrWidth / 2
        clockCentreY = scrHeight / 2
        minimum = min(scrWidth, scrHeight)
        clockRadius = minimum / 2 - scrPadding
        hourHandSize = clockRadius - clockRadius / 2
        handSize = clockRadius - clockRadius / 4
        angle = PI / 30 - PI / 2
        isInit = true
    }

    private fun setPaintAttrs(color: Int, style: Style, strokeWidth: Float) {
        paint.reset()
        paint.color = color
        paint.style = style
        paint.strokeWidth = strokeWidth
        paint.isAntiAlias = true

    }


    private fun drawCircle(canvas: Canvas?) {
        setPaintAttrs(Color.BLACK, Style.STROKE, 20f)
        canvas?.drawCircle(clockCentreX, clockCentreY, clockRadius, paint)
    }

    private fun drawHands(canvas: Canvas?) {
        calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR_OF_DAY)
        minute = calendar.get(Calendar.MINUTE)
        second = calendar.get(Calendar.SECOND)
        hour = if (hour > 12) hour - 12 else hour
        drawHourHand(canvas, (hour + minute / 60.0) * 5.0)
        drawMinuteHand(canvas, minute*1f)
        drawSecondHand(canvas, second*1f)
    }

    private fun drawHourHand(canvas: Canvas?, time: Double) {
        setPaintAttrs(Color.RED, Style.STROKE, 10f)
        angle = PI * time / 30 - PI / 2
        canvas?.drawLine(
            clockCentreX, clockCentreY,
            (clockCentreX * cos(angle) * hourHandSize).toFloat(),
            (clockCentreY * sin(angle) * hourHandSize).toFloat(), paint
        )
    }
    private fun drawMinuteHand(canvas: Canvas?, time: Float) {
        setPaintAttrs(Color.BLUE, Style.STROKE, 10f)
        angle = PI * time / 30 - PI / 2
        canvas?.drawLine(
            clockCentreX, clockCentreY,
            (clockCentreX * cos(angle) * handSize).toFloat(),
            (clockCentreY * sin(angle) * handSize).toFloat(), paint
        )
    }
    private fun drawSecondHand(canvas: Canvas?, time: Float) {
        setPaintAttrs(Color.BLACK, Style.STROKE, 10f)
        angle = PI * time / 30 - PI / 2
        canvas?.drawLine(
            clockCentreX, clockCentreY,
            (clockCentreX * cos(angle) * handSize).toFloat(),
            (clockCentreY * sin(angle) * handSize).toFloat(), paint
        )
    }



}







