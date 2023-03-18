package com.example.ignetilabtest.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ignetilabtest.R
import com.example.ignetilabtest.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



    }//class
}