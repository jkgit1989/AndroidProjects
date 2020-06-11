package com.example.firstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val instance = T(22345, 32345)

        var temp = ""
        var name = "Jitendra Kumar"

        for (i in name) {
            print(i)
            try {
                Thread.sleep(10)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            temp = temp + i
            tv.setText(i.toString())
            tv.setTextSize(20.0f)
        }


    }


    class T(var x: Int, var y: Int) {

        var a = 0
        var b = 0

        init {
            a = x
            b = y
        }

        fun add(): Int {
            return a + b;
        }
    }
}
