package com.example.bitmaptest

import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cut.*
import org.jetbrains.anko.image

class Thumbnails_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cut)
        initview()
    }

    private fun initview() {
        sr.setImageResource(R.drawable.m)
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.m)
        var bit = ThumbnailUtils.extractThumbnail(bitmap, 50, 60)
        news.setImageBitmap(bit)

    }
}
