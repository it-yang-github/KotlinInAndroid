package com.example.bitmaptest.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.a40248.kotlininandroid.utils.showToas
import com.example.bitmaptest.R
import kotlinx.android.synthetic.main.activity_main.view.*

/**
 * Created by 40248 on 2017/7/7.
 */
class AlpaBitmap : View {
    var old: Bitmap

    @JvmOverloads
    constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        old = BitmapFactory.decodeResource(resources, R.drawable.bitmap)
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var pan = Paint()
        canvas?.drawColor(Color.BLACK)
        var buf = IntArray(old.width * old.height)
        old.getPixels(buf, 0, old.width, 0, 0, old.width, old.height)
        var new = Bitmap.createBitmap(old.width, old.height, Bitmap.Config.ARGB_8888)
        var buf1 = buf.map {
            it ->
            var a =Color.alpha(it)-150
            if(a<0)a=0
            var r = Color.red(it)
            var g = Color.green(it)
            var b = Color.blue(it)
            Color.argb(a, r,g,b)
        }
        buf1.map {
            Log.e("Tag", "a=${Color.alpha(it)}")
        }
        new.setPixels(buf1.toIntArray(), 0, old.width, 0, 0, old.width, old.height)
        canvas?.drawBitmap(old, 0f, 0f, pan)
        if (canvas != null) {
            canvas.drawBitmap(new, 0f, old.height.toFloat(), pan)
        }


    }


}








