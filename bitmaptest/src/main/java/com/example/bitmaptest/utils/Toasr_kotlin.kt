package com.example.a40248.kotlininandroid.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Toast

/**
 * Created by 40248 on 2017/7/5.
 */
fun Context.showToas(msg: String, du: Int = Toast.LENGTH_SHORT) {
//    var a = Tu::show
//    a.invoke(msg, this, du)
    Tu.show(msg, this, du)
}
object Tu {
    var toast: Toast? = null
    fun show(msg: String, context: Context, du: Int) {
        if (toast == null)
            toast = Toast.makeText(context, msg, du)
        toast!!.setText(msg)
        toast!!.show()
    }
}

