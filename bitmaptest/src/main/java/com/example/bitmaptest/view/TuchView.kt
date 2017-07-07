package com.example.bitmaptest.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.bitmaptest.R

/**
 * Created by 40248 on 2017/7/7.
 */

class TuchView : View {

    /** 画笔 */
    lateinit var pain: Paint
    /** 背景 图片 */
    lateinit var back: Bitmap
    /** 画笔宽度   */
    var strokeWidth: Float = 10.0f
    /**  画笔颜色 */
    var pain_color: Int = Color.RED
    /** 按下的坐标 */
    var clicPoint: PointF = PointF(0f, 0f)
    /**  移动 坐标 */
    var movePoint: PointF = PointF(0f, 0f)
    /** 清除屏幕时用 */
    lateinit var clearBitmap: Bitmap
    /**  滑动时用 */
    lateinit var pathBitmap: Bitmap
    /** 是否是清除*/
    var isClear: Boolean = false
    /** 是否 正在移动 */
    var isActionMove: Boolean = true

    @JvmOverloads
    constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        back = BitmapFactory.decodeResource(context?.resources, R.drawable.m).copy(Bitmap.Config.ARGB_8888, true)
        pathBitmap = Bitmap.createBitmap(back)
        pain = Paint()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var btmap = handWriting()
        canvas?.drawBitmap(btmap, 0f, 0f, null)
    }

    fun handWriting(): Bitmap {
        var canvas: Canvas = if (isClear) {
            Canvas(clearBitmap)
        } else {
            Canvas(pathBitmap)
        }
        initPain()
        if (isActionMove) {
            canvas.drawLine(clicPoint.x, clicPoint.y, movePoint.x, movePoint.y, pain)
        }
        clicPoint.x = movePoint.x
        clicPoint.y = movePoint.y
        if (isClear) {
            return clearBitmap
        }
        return pathBitmap
    }

    fun initPain() {
        pain.style = Paint.Style.STROKE
        pain.isAntiAlias = true
        pain.color = pain_color
        pain.strokeWidth = strokeWidth
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            movePoint.x = event.getX()
            movePoint.y = event.getY()
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    isActionMove = false
                    invalidate()
                    return true
                }
                MotionEvent.ACTION_MOVE -> {
                    isActionMove = true
                    invalidate()
                    return true
                }
            }
        }
        return super.onTouchEvent(event)
    }

    fun clear() {
        isClear = true;
        clearBitmap = Bitmap.createBitmap(back);
        invalidate();
    }

    /**
     *      int width = this.getMeasuredSize(widthMeasureSpec, true);  
      int height = this.getMeasuredSize(heightMeasureSpec, false);  
      setMeasuredDimension(width, height);

    设置  控件的高度  
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(back?.width, back.height);
    }
}