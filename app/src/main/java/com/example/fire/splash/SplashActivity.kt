package com.example.fire.splash

import android.os.Bundle
import android.os.CountDownTimer
import com.example.fire.R
import com.example.fire.common.CommonActivity
import com.example.fire.common.MainActivity
import com.example.fire.login.LoginActivity
import org.jetbrains.anko.startActivity

class SplashActivity : CommonActivity() {
    private lateinit var time: CountDownTimer
    private var isLogin = true

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData(savedInstanceState: Bundle?) {
        time = object : CountDownTimer(2 * 1000, 1000) {
            override fun onFinish() {
                if (isLogin) {
                    startActivity<LoginActivity>()
                    finish()
                } else {
                    startActivity<MainActivity>()
                    finish()
                }
            }

            override fun onTick(millisUntilFinished: Long) {}
        }
        time.start()
    }
}
