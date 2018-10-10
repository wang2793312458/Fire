package com.example.fire.common.http

/**
 * @author by 王小智
 * Created on 2018/10/8.
 */
data class HttpResponseData(
  val code: Int,
  val msg: String,
  val data: Any
)