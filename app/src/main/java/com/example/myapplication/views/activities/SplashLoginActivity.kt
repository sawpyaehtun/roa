package com.example.myapplication.views.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.views.SplashLogInView
import com.example.myapplication.entity.request.SignInBody
import com.example.myapplication.presenter.SignInPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_splash_login.*
import kotlinx.android.synthetic.main.login_num_pad.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.android.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.myapplication.retrofit.RetrofitAdapter
import javax.inject.Inject


class SplashLoginActivity : BaseActivity(), View.OnClickListener, SplashLogInView {


    @Inject
    lateinit var signInPresenter: SignInPresenter

    companion object  {
        /**
         * this fun is called by settingFragment and RefreshTokenAuthenticator to open Signin screen
         */
        fun intentResetToSignIn(context: Context): Intent {
            val intent = Intent(context, SplashLoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_login)
        loadSplashAndLogin()
        setOnClickListner()

        signInPresenter.test("hello sir you are genious.")
    }


    private fun loadSplashAndLogin() {
        splashLogo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up_logo))
        GlobalScope.launch(Dispatchers.Main) {
            delay(1500)
            password.visibility = View.VISIBLE
            delay(1000)
            numpad.visibility = View.VISIBLE
        }
    }

    private fun setOnClickListner() {
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        zero.setOnClickListener(this)
        back.setOnClickListener(this)
        enter.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                one.id -> typePassword("1")
                two.id -> typePassword("2")
                three.id -> typePassword("3")
                four.id -> typePassword("4")
                five.id -> typePassword("5")
                six.id -> typePassword("6")
                seven.id -> typePassword("7")
                eight.id -> typePassword("8")
                nine.id -> typePassword("9")
                zero.id -> typePassword("0")
                back.id -> password.setText(delete(password.text.toString()))
                enter.id -> signIn()
                else -> {
                }
            }
        }
    }

    @SuppressLint("CheckResult")
    private fun signIn()
    {
        val adapter = RetrofitAdapter()
        val mService = adapter.createObserableService("http://192.168.99.12/api_0.1/public/api/")

        val signInBody = SignInBody("123", "456")
        val recall = mService.signIn(signInBody)

        recall.subscribeOn(Schedulers.io())
            .doOnSubscribe { Log.e("Success", "Success") }
            .doOnError {
                Log.e("error", it.message)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                Log.e("success",it.success)
                Log.e("token",it.token)
            }
    }

    private fun typePassword(num: String) {
        password.text.append(num)
    }

    private fun delete(passStr: String): String {
        var str = passStr
        if (str.isNotEmpty()) {
            str = str.substring(0, str.length - 1)
        }
        return str
    }

    override fun openMainScreen(password: String) {
        Toast.makeText(this, password, Toast.LENGTH_LONG).show();
    }

    override fun showSignInError() {

    }
}
