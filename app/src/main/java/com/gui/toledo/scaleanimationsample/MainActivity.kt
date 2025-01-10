package com.gui.toledo.scaleanimationsample

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import androidx.activity.ComponentActivity
import androidx.core.view.setMargins

class MainActivity : ComponentActivity() {

    private var customScaleView: CustomScaleView? = null
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        customScaleView = CustomScaleView(this)

        val linear = LinearLayout(this)
        linear.setBackgroundColor(Color.GRAY)

        val params = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(80)
        }

        customScaleView?.layoutParams = params

        linear.addView(customScaleView)

        setContentView(linear)

        handler = Handler(Looper.getMainLooper())
    }

    override fun onResume() {
        super.onResume()
        handler?.postDelayed({
            customScaleView?.startScaleAnimation()
        }, 2000)
    }
}