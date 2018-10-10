package com.example.fire.common.http

import com.example.fire.common.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.SECONDS

/**
 * Created by iCong on 06/01/2018.
 */
object UploadFactory {

  private val client = OkHttpClient.Builder()
      .connectTimeout(30, SECONDS)
      .readTimeout(1, TimeUnit.MINUTES)
      .writeTimeout(1, TimeUnit.MINUTES)
      .addInterceptor(UploadInterceptor())
      .build()

  private val retrofit = Retrofit.Builder()

  fun getInstance(): Api {
    return retrofit
        .baseUrl(Api.API_UPLOAD_IMAGE)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(HttpResultConverter())
        .build()
        .create(Api::class.java)
  }

  fun <T> schedulers(): io.reactivex.ObservableTransformer<T, T> {
    return io.reactivex.ObservableTransformer { upstream ->
      upstream.subscribeOn(Schedulers.io())
          .observeOn(
              AndroidSchedulers.mainThread()
          )
    }
  }
}