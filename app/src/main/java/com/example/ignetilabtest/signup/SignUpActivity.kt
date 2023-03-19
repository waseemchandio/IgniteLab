package com.example.ignetilabtest.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ignetilabtest.R
import com.example.ignetilabtest.databinding.ActivitySignUpActiviityBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpActiviityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpActiviityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.signUpButton.setOnClickListener {
            var name = binding.edtName.text.toString()
            var phone = binding.edtPhone.text.toString()
            var email = binding.edtEmail.text.toString()
            var password = binding.edtPassword.text.toString()

        }



    }//class
}