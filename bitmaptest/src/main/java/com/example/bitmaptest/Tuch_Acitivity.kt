package com.example.bitmaptest

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tuch.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.lang.reflect.Method
import java.util.*

class Tuch_Acitivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuch)
        clear.onClick {
            tuchv.clear()
            var rd = Random()
            tuchv.pain_color = rd.nextInt()
        }

    }
}
