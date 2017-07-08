package com.example.kotlindatabase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a40248.kotlininandroid.utils.showToas
import com.example.kotlindatabase.db.DBhelp
import com.example.kotlindatabase.db.DBhelp.Companion.database
import com.example.kotlindatabase.doman.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.selects.select
import org.jetbrains.anko.ctx
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initlinsener()
    }

    private fun initlinsener() {
        insert.onClick {
            /**
             *插入 一条记录
             */
            database.use {
                insert("user"
                        , "name" to "zhangsan"
                        , "paswd" to "123"
                )
            }
            quer.onClick {
                /**
                 * 查询
                 */
                database.use({
                    select("user", "name").whereSimple("name=?", "zhangsan").exec {
                        while (moveToNext()) {
                            Log.e("TAG","size= ${columnCount} ${getString(0)}")
                        }
                    }

                })
            }
        }

    }
}
