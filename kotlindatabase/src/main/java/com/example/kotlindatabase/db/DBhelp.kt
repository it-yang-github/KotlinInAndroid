package com.example.kotlindatabase.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by 40248 on 2017/7/8.
 */
class DBhelp(var ctx: Context) : ManagedSQLiteOpenHelper(ctx, "Mydb") {

    companion object {
        private var instance: DBhelp? = null

        @Synchronized
        fun getInstance(ctx: Context): DBhelp {
            if (instance == null) {
                instance = DBhelp(ctx.getApplicationContext())
            }
            return instance!!
        }

        val Context.database: DBhelp
            get() = DBhelp.getInstance(getApplicationContext())
    }

    override fun onCreate(db: SQLiteDatabase?) {

        db?.createTable(
                "user"
                , false,
                "id" to INTEGER + PRIMARY_KEY        // 加上报错+ AUTOINCREMENT
                , "name" to TEXT
                , "paswd" to TEXT
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}