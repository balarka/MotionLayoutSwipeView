package com.my.motionlayoutslider

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
import kotlinx.android.synthetic.main.motion_layout.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion_layout)
        LayoutInflater.from(this).inflate(R.layout.motion_layout, null)
        val ml = findViewById<MotionLayout>(R.id.motionLayout)

        ml.addTransitionListener(object : TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                if (p1 == R.id.end2) {
                    ml.animate()
                        .alpha(0f)
                        .setDuration(250)
                        .setListener(object : Animator.AnimatorListener {
                            override fun onAnimationStart(p0: Animator?) {
                            }

                            override fun onAnimationEnd(p0: Animator?) {
                                ml.visibility = View.GONE
                                Toast.makeText(this@MainActivity, "Message deleted!", Toast.LENGTH_SHORT).show()
                            }

                            override fun onAnimationCancel(p0: Animator?) {
                            }

                            override fun onAnimationRepeat(p0: Animator?) {
                            }
                        })
                }
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }
        })

        forward.setOnClickListener {
            Toast.makeText(this, "Forward the email", Toast.LENGTH_SHORT).show()
        }

        archive.setOnClickListener {
            Toast.makeText(this, "Archived the email!", Toast.LENGTH_SHORT).show()
        }

    }
}