package com.example.fire.home

import android.content.Context
import com.example.fire.R
import com.example.fire.common.Api
import com.example.fire.common.CommonFragment
import com.example.fire.utils.GlideImageLoader
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.fragment_home.banner
import org.jetbrains.anko.support.v4.ctx

/**
 * @author by 王小智
 * Created on 2018/10/12.
 */
class HomeFragment : CommonFragment(), HomeContract.View {

  override lateinit var mPresent: HomeContract.Present

  override fun getContentViewLayoutId(): Int {
    return R.layout.fragment_home
  }

  override fun initData() {
    HomePresent(this)
    mPresent.start()
    val images = arrayListOf<String>()
    images.add(Api.API_LOAD_IMAGE + "20180921/153749393434637924/1537493951449.jpg")
    images.add(Api.API_LOAD_IMAGE + "20180921/153749396236722005/1537493995191.jpg")
    banner.setImages(images)
        .setImageLoader(GlideImageLoader())
        .setIndicatorGravity(BannerConfig.CENTER)
        .start()
  }

  override fun showMessage(var1: String) {

  }

  override fun showMessage(var1: Int) {
  }

  override fun showProgress() {
  }

  override fun hideProgress() {
  }

  override fun getActOrCtx(): Context {
    return ctx
  }

}