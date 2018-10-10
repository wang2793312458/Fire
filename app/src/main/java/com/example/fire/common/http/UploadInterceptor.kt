package com.example.fire.common.http

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Request
import okhttp3.Response
import okio.Buffer
import java.io.EOFException
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
/**
 * Created by iCong on 2017/6/26.
 */

class UploadInterceptor : Interceptor {
  private val UTF_8 = Charset.forName("UTF-8")
  private val TAG = HttpFactory::class.java.simpleName

  override fun intercept(chain: Chain?): Response {
    val request: Request? = chain?.request()
    val requestBody = request?.body()
    val url = request?.url()
    val newUrl = url?.newBuilder()
    val buffer = Buffer()
    requestBody?.writeTo(buffer)
    val parameter = buffer.readString(UTF_8)
    buffer.flush()
    buffer.close()
    Log.i(
        TAG, "parameter   ->[*_*]   ：$parameter\n" +
        "url   ->[Q_Q]     ：$url\n" +
        "host  ->[@_@]     ：${url?.host()}\n" +
        "method->[^_^]     ：${request?.method()}"
    )
    val requestBuilder = request?.newBuilder()
        ?.method(request.method(), request.body())
        ?.url(newUrl?.build())
    val newRequest = requestBuilder?.build()
    val startNs = System.nanoTime()
    val response = chain?.proceed(newRequest)!!
    val tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs)
    val body = response.body()!!
    val contentLength = body.contentLength()
    val source = body.source()
    source.request(Long.MAX_VALUE)
    val responseBuffer = source.buffer()

    if (!isPlaintext(responseBuffer)) {
      return response
    }
    if (contentLength != 0L) {
      Log.i(
          TAG, "url:${response.request().url()}\n${responseBuffer.clone().readString(
          UTF_8
      )}\ntimer:${tookMs}ms"
      )
    }
    return response
  }

  /**
   * Returns true if the body in question probably contains human readable text. Uses a small sample
   * of code points to detect unicode control characters commonly used in binary file signatures.
   */
  @Throws(EOFException::class)
  private fun isPlaintext(buffer: Buffer): Boolean {
    try {
      val prefix = Buffer()
      val byteCount = if (buffer.size() < 64) buffer.size() else 64
      buffer.copyTo(prefix, 0, byteCount)
      for (i in 0..15) {
        if (prefix.exhausted()) {
          break
        }
        val codePoint = prefix.readUtf8CodePoint()
        if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
          return false
        }
      }
      return true
    } catch (e: EOFException) {
      return false // Truncated UTF-8 sequence.
    }

  }

}