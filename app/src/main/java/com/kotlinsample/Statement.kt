package com.kotlinsample

import android.util.Log

public class Statement {


    val tag = "STATEMENT_D"

    fun dowork() {
        Log.e("_D", "statementclass")

        //statement

        var num = if (10 > 20) {
            "10 is greater"
        } else if (20 > 10) {
            "20 is greater"
        } else {
            "both are same"
        }

        Log.e(tag, num)

        num = if (num.contains("10")) {
            "10"
        } else {
            "20"
        }


//switchcase

        when (num) {
            "10" -> Log.e(tag + "when", "10 is greater")
            "20" -> Log.e(tag + "when", "20 is greater")
            else -> Log.e(tag + "when", "both are same")


        }

        val alists = listOf("A","B","C","E","F")

        for (a in alists)
        {
            Log.e(tag+"for",a)
        }


    }

}