package com.learnandroid.mvvmloginregsample.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.learnandroid.mvvmloginregsample.data.repository.UserRepository

class AuthViewModel : ViewModel() {
    var email:String? = null
    var password:String? = null

    var authListener: AuthListener? = null

    fun loginButtonClick(view: View){
        authListener?.onStarted()
           if (email.isNullOrEmpty() || password.isNullOrEmpty()){
               authListener?.onFailure("Invalid email and password")
               return
           }
         val loginResponse = UserRepository().userLogin(email!!,password!!)
        authListener?.onSuccess(loginResponse)
    }

    fun goRegisterPage(view: View){

    }
}