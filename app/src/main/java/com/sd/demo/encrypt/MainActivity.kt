package com.sd.demo.encrypt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sd.demo.encrypt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val _binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(_binding.root)
    }
}

inline fun logMsg(block: () -> String) {
    Log.i("encrypt-demo", block())
}