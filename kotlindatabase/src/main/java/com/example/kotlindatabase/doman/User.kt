package com.example.kotlindatabase.doman

/**
 * Created by 40248 on 2017/7/8.
 *
 *                "user"
, true,
"id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT
, "name" to TEXT
, "paswd" to TEXT
 */
data class User(var id :Int,var name:String ,var paswd :String){

}