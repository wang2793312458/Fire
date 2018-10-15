package com.example.fire.common.http

/**
 * @author by 王小智
 * Created on 2018/10/8.
 */
data class HttpResponse(
  val state: Int,
  val res: HttpResponseData,
  val msg: String

//  val error: Boolean,
//  val results: Any

)