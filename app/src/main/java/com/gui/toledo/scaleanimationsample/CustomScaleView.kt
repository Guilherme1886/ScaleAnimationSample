package com.gui.toledo.scaleanimationsample

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CustomScaleView : View {

    private lateinit var paint: Paint
    private var rectF: RectF = RectF()
    private var scaleValue = 1f

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        paint = Paint()
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true

        rectF = RectF(100f, 100f, 500f, 500f)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()
        canvas.scale(
            scaleValue,
            scaleValue,
            rectF.centerX(),
            rectF.centerY()
        )

        canvas.drawRoundRect(rectF, 50f, 50f, paint)
        canvas.restore()
    }

    fun startScaleAnimation() {
        val scaleX = ObjectAnimator.ofFloat(this, "scaleValue", 1f, 2f)
        val scaleY = ObjectAnimator.ofFloat(this, "scaleValue", 1f, 2f)

        scaleX.setDuration(2000)
        scaleY.setDuration(2000)

        scaleX.start()
        scaleY.start()
    }

    fun setScaleValue(scaleValue: Float) {
        this.scaleValue = scaleValue
        invalidate()
    }
}