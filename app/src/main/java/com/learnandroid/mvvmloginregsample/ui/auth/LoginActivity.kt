package com.learnandroid.mvvmloginregsample.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.learnandroid.mvvmloginregsample.R
import com.learnandroid.mvvmloginregsample.databinding.ActivityLoginBinding
import com.learnandroid.mvvmloginregsample.utils.toast

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_login)
        val binding: ActivityLoginBinding= DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() {
       toast("login start")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
    loginResponse.observe(this, Observer {
        toast(it)
        println(it)
    })
    }

    override fun onFailure(message: String) {
    toast(message)
    }
}