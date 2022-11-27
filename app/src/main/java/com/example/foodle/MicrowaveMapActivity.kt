package com.example.foodle

import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import android.widget.ImageView
import kotlin.math.max
import kotlin.math.min
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.PI
import kotlin.properties.Delegates

// Ref: https://www.tutorialspoint.com/android-imageview-zoom-in-and-zoom-out-using-kotlin
// Allows for zoomable functionality
private lateinit var microwaveMapImage: ImageView
private lateinit var scaleGestureDetector: ScaleGestureDetector
private var scaleFactor = 1.0f

// Ref: https://www.youtube.com/watch?v=x33dC7E_Lho
// Allows for draggable functionality

class MicrowaveMapActivity : AppCompatActivity() {

    private var xPos by Delegates.notNull<Float>()
    private var yPos by Delegates.notNull<Float>()
    private var dx by Delegates.notNull<Float>()
    private var dy by Delegates.notNull<Float>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_microwave_map)
        // Get a support ActionBar corresponding to this toolbar and enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        microwaveMapImage = findViewById(R.id.microwave_map_image)
        scaleGestureDetector = ScaleGestureDetector(this, ScaleListener())
    }

    override fun onTouchEvent(motionEvent: MotionEvent): Boolean {
        scaleGestureDetector.onTouchEvent(motionEvent)

        if (motionEvent.action == MotionEvent.ACTION_DOWN) {
            xPos = motionEvent.x
            yPos = motionEvent.y
        }

        if (motionEvent.action == MotionEvent.ACTION_MOVE) {
            dx = motionEvent.x - xPos
            dy = motionEvent.y - yPos

            microwaveMapImage.x = microwaveMapImage.x + dx
            microwaveMapImage.y = microwaveMapImage.y + dy

            xPos = motionEvent.x
            yPos = motionEvent.y
        }

        return true
    }

    private inner class ScaleListener : SimpleOnScaleGestureListener() {
        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
            scaleFactor *= scaleGestureDetector.scaleFactor
            scaleFactor = max(0.1f, min(scaleFactor, 10.0f))
            microwaveMapImage.scaleX = scaleFactor
            microwaveMapImage.scaleY = scaleFactor
            return true
        }
    }
}