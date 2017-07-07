package com.example.bitmaptest.view


import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.bitmaptest.R

/**
 * Created by 40248 on 2017/7/7.
 */

class BitMapView : View {
     var old: Bitmap
     var pan: Paint
    @JvmOverloads
    constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        old = BitmapFactory.decodeResource(resources, R.drawable.m)
        pan = Paint()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas != null) {
            canvas.drawColor(Color.WHITE)
            canvas.drawBitmap(old, 0f, 0f, pan)
            var matrix = Matrix()
            matrix.setScale(-1f,-1f)
        //    matrix.postRotate(-45f)
           // matrix.postRotate(-45f)
            matrix.postTranslate(old.width.toFloat(),old.height.toFloat())
            var newbtmap = Bitmap.createBitmap(old, 0, 0, old.width, old.height, matrix, true)

            canvas.drawBitmap(newbtmap, 0f, old.height.toFloat(), pan)
        }


    }

}


