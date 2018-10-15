package com.example.fire.common

import com.example.fire.login.entity.LoginData
import com.example.fire.message.entity.MessageData
import com.example.fire.mine.fragment.entity.MineData
import com.example.fire.xxxx.GankData
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {
  companion object {
    const val API_DEFAULT_HOST = "http://www.taoshunda.com:80/taoshundainter/mobile/"
    const val API_LOAD_IMAGE = "http://www.taoshunda.com:80/images/"
    const val API_UPLOAD_IMAGE = "http://www.taoshunda.com:80/fileupload/"
    const val API_GANK_API = "http://gank.io/api/"
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

  //分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
  //数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
  //请求个数： 数字，大于0
  //第几页：数字，大于0
  @GET("data/{type}/{num}/{page}")
  fun getGankData(
    @Path("type") type: String,
    @Path("num") num: String, @Path("page") page: String
  ): Observable<ArrayList<GankData>>
}
