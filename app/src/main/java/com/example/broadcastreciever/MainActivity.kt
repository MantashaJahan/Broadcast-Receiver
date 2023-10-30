package com.example.broadcastreciever

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var receiver: AirplaneModeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = AirplaneModeChangeReceiver()


        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {

            registerReceiver(receiver, it)
        }
    }


    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}
