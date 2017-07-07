package com.example.bitmaptest

import android.content.Intent
import android.graphics.Bitmap
import android.media.ThumbnailUtils
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import java.io.File

class MainActivity : AppCompatActivity() {
    var pat = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ininitLisenner()

    }

    private fun ininitLisenner() {
        alpa.onClick {
            startActivity<AlpaActuvity>()
        }
        bitmap.onClick {
            startActivity<Rote_Activity>()
        }
        tuch.onClick {
            startActivity<Tuch_Acitivity>()
        }
        cut.onClick {
            var intent = Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            intent.putExtra("crop", "true");// crop=true 有这句才能出来最后的裁剪页面.
            intent.putExtra("aspectX", 1);// 这两项为裁剪框的比例.
            intent.putExtra("aspectY", 2);// x:y=1:2
            pat = Environment.getExternalStorageDirectory().toString()
            intent.putExtra("output", Uri.fromFile(File(pat, "a.jpg")));
            intent.putExtra("outputFormat", "JPEG");//返回格式
            startActivityForResult(Intent.createChooser(intent, "选择图片"), 0);

        }
        thumbnails.onClick {
            startActivity<Thumbnails_activity>()
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    }
}
