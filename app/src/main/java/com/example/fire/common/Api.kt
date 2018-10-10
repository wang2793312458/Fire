package com.example.fire.common

import com.example.fire.login.entity.LoginData
import com.example.fire.message.entity.MessageData
import com.example.fire.mine.fragment.entity.MineData
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
  companion object {
    const val API_DEFAULT_HOST = "http://www.taoshunda.com:80/taoshundainter/mobile/"
    const val API_LOAD_IMAGE = "http://www.taoshunda.com:80/images/"
    const val API_UPLOAD_IMAGE = "http://www.taoshunda.com:80/fileupload/"
  }

  // 获取消息
  @POST("push/findPushList")
  fun getMsg(@Body map: Map<String, String>): Observable<ArrayList<MessageData>>

  // 登录
  @POST("user/login")
  fun login(@Body map: Map<String, String>): Observable<LoginData>

  //获取验证码
  @POST("msg/getMobileCode")
  fun getCodeForRegister(@Body map: Map<String, String>): Observable<Boolean>

  //验证验证码
  @POST("msg/checkRegisterCode")
  fun checkCodeMsg(@Body map: Map<String, String>): Observable<Boolean>

  //注册
  @POST("user/register")
  fun getRegister(@Body map: Map<String, String>): Observable<LoginData>

  //个人详情页面
  @POST("user/getUserInfo")
  fun getUserInfo(@Body map: Map<String, String>): Observable<MineData>

  //忘记密码获取验证码
  @POST("msg/getForeignPwdCode")
  fun getForeignPwdCode(@Body map: Map<String, String>): Observable<Boolean>

  //忘记密码验证
  @POST("msg/checkForeignPwdCode")
  fun getCheckForeignPwdCode(@Body map: Map<String, String>): Observable<Boolean>

  //忘记密码修改密码
  @POST("user/foreignPwd")
  fun getForeignPwd(@Body map: Map<String, String>): Observable<Boolean>

}