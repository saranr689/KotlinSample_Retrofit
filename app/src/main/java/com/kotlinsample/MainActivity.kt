package com.kotlinsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var retrofit_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofit_btn = findViewById(R.id.id_retrofit_btn)
        retrofit_btn.setOnClickListener(View.OnClickListener {
            callRetrofit()
        })
        com.kotlinsample.Statement().dowork()
    }

    private fun callRetrofit() {

        val retrofit = Retrofit.Builder()
                .baseUrl("https://en.wikipedia.org/w/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val retrofit_crete = retrofit.create(WebApiCall::class.java)

        retrofit_crete.hitCountCheck("query", "json", "search", "h").enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>?, response: Response<Model>?) {

                if (response != null) {
                    Log.d("_D", response.code().toString())
                }
            }

            override fun onFailure(call: Call<Model>?, t: Throwable?) {
                if (t != null) {
                    Log.d("_D_F", t.message)
                }
            }


        })

    }
}
