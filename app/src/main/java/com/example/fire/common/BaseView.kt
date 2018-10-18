package com.example.fire.common

import android.content.Context

interface BaseView {
     fun showMessage(var1: String)

     fun showMessage(var1: Int)

     fun showProgress()

     fun hideProgress()

     fun getActOrCtx(): Context
}