package com.example.fire.common.http

/**
 * @author by 王小智
 * Created on 2018/10/8.
 */
object TokenManager {
  private var token: String? = null
  fun setToken(token: String) {
    TokenManager.token = token
  }

  fun getToken(): String? {
    return token
  }
}