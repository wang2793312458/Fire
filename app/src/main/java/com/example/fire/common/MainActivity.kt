package com.example.fire.common

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.fire.R
import com.example.fire.home.HomeFragment
import com.example.fire.message.MessageFragment
import com.example.fire.mine.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.tabhost
import org.jetbrains.anko.toast

class MainActivity : CommonActivity() {
  //定义FragmentTabHost对象
  private val mViewFrags = arrayOf<Class<*>>(
      HomeFragment::class.java, MessageFragment::class.java, MineFragment::class.java
  )
  //Tab图片
  private val mImageViewArray =
    intArrayOf(R.drawable.tab_polling, R.drawable.tab_message, R.drawable.tab_mine)
  //Tab文字
  private val mDataTv = intArrayOf(R.string.home, R.string.message, R.string.mine)
  private var exitTime: Long = 0

  override fun getContentViewLayoutId(): Int {
    return R.layout.activity_main
  }

  override fun initData(savedInstanceState: Bundle?) {
    tabhost!!.setup(this, supportFragmentManager, R.id.home_fl_content)
    val count = mViewFrags.size
    for (i in 0 until count) {
      val tabSpec = tabhost!!.newTabSpec(mDataTv[i].toString())
          .setIndicator(getTabItemView(i))
      tabhost!!.addTab(tabSpec, mViewFrags[i], null)
    }
    tabhost!!.tabWidget.dividerDrawable = null
  }

  /**
   * 给Tab按钮设置图标和文字
   */
  private fun getTabItemView(index: Int): View {
    @SuppressLint("InflateParams")
    val view = LayoutInflater.from(this)
        .inflate(R.layout.item_tab, null)
    val imageView = view.findViewById<ImageView>(R.id.tab_image)
    val textView = view.findViewById<TextView>(R.id.tab_text)
    imageView.setImageResource(mImageViewArray[index])
    textView.setText(mDataTv[index])
    return view
  }

  override fun onKeyLongPress(
    keyCode: Int,
    event: KeyEvent
  ): Boolean {
    if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_DOWN) {
      toast(R.string.exit_again)
      exitTime = System.currentTimeMillis()
      true
    } else {
      ActivityCollector.finishAll()
      System.exit(0)
      true
    }
    return super.onKeyLongPress(keyCode, event)
  }
}
