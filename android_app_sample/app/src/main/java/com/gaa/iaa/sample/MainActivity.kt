package com.gaa.iaa.sample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gaa.sdk.iaa.MobileAds

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text)
        findViewById<Button>(R.id.btn).setOnClickListener {
            openOfferWall {
                textView.text = it
            }
        }
    }

    private fun openOfferWall(callback : (String) -> Unit) {
        MobileAds(applicationContext).openOfferWall(this@MainActivity) { iaaResult ->
            Log.d("MainActivity", iaaResult.toString())
            callback(iaaResult.toString())
        }
    }

}