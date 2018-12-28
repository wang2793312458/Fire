package com.example.fire.common

import com.example.fire.home.entity.HomeKeyData
import com.example.fire.home.entity.HomeShopData
import com.example.fire.login.entity.LoginData
import com.example.fire.message.entity.MessageData
import com.example.fire.mine.address.entity.MineAddressData
import com.example.fire.mine.fragment.entity.MineData
import com.example.fire.mine.info.entity.MineInfoData
import com.example.fire.mine.setUp.entity.AboutData
import com.example.fire.mine.setUp.entity.MobilesData
import com.example.fire.mine.setUp.entity.UpgradeData
import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface Api {
    companion object {
        const val API_DEFAULT_HOST = "http://www.taoshunda.com:80/taoshundainter/mobile/"
        const val API_LOAD_IMAGE = "http://www.taoshunda.com:80/images/"
        const val API_UPLOAD_IMAGE = "http://www.taoshunda.com:80/fileupload/"
        const val API_GANK_API = "http://gank.io/api/"
    }

    //上传图片
    @Multipart
    @POST("file/uploadImages")
    fun upload(@Part file: MultipartBody.Part): Observable<List<String>>

    //上传文件
    @Multipart
    @POST("file/uploadImages")
    fun uploads(@Part files: List<MultipartBody.Part>): Observable<List<String>>

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

    //我的页面
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

    //1反馈
    @POST("feedBack/feedBack")
    fun getFeedback(@Body map: Map<String, String>): Observable<Boolean>

    //关于我们
    @POST("link/getLinkUrlById")
    fun getAboutUS(@Body map: Map<String, String>): Observable<AboutData>

    //联系客服
    @POST("aboutUs/contactService")
    fun getMobiles(@Body map: Map<String, String>): Observable<MobilesData>

    // 检查更新
    @POST("sys/checkAppVersion")
    fun upgrade(@Body map: Map<String, String>): Observable<UpgradeData>

    //个人详情页面
    @POST("user/getUserInfo")
    fun getUserInfoDetail(@Body map: Map<String, String>): Observable<MineInfoData>

    //首页轮播图下方关键字
    @POST("homopage/getHomePageType")
    fun getHomePageType(@Body map: Map<String, String>): Observable<ArrayList<HomeKeyData>>

    //首页商家列表
    @POST("homopage/getRecommendBussiness")
    fun getHomeShopList(@Body map: Map<String, String>): Observable<ArrayList<HomeShopData>>

    //地址列表
    @POST("address/getAddressList")
    fun getAddressList(@Body map: Map<String, String>): Observable<ArrayList<MineAddressData>>

}
