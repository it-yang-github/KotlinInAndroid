package com.example.animation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.activity_other_activity.*
import org.jetbrains.anko.sdk25.coroutines.onClick


class Other_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initltener()
    }

    fun initltener() {

        alpa.onClick {
            ObjectAnimator.ofFloat(alpa, "alpha", 0f, 1f, 0f, 1f)
                    .setDuration(6000)
                    .start()
        }
        move.onClick {
            var animet = ObjectAnimator.ofFloat(move, "translationY", 0f, 500f, 0f).setDuration(3000)
            animet.start()
        }
        scle.onClick {
            var animet = ObjectAnimator.ofFloat(scle, "scaleY", 0f, 5f, 1f).setDuration(5000)
            animet.start()
        }
        rotate.onClick {
            var animet = ObjectAnimator.ofFloat(rotate, "rotationX", 0f, 360f, 0f).setDuration(5000)
            animet.start()
        }
        set.onClick {
            var anmt = ObjectAnimator.ofFloat(set, "rotation", 0f, 3600f)
            //var a1 = ObjectAnimator.ofFloat(set, "rotationY", 0f, 360f, 0f).setDuration(5000)
            var a2 = ObjectAnimator.ofFloat(set, "scaleY", 0f, 5f, 1f).setDuration(5000)
            var a3 = ObjectAnimator.ofFloat(set, "translationY", 0f, 500f, 0f).setDuration(3000)
            var a4 = ObjectAnimator.ofFloat(set, "alpha", 0f, 1f, 0f, 1f).setDuration(3000)
            var animet = AnimatorSet()
            animet.play(a2).with(a3).with(a4).with(anmt)
            animet.duration = 5000
            animet.start()
        }


    }
}

