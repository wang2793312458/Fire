package com.example.fire.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fire.R
import com.youth.banner.loader.ImageLoader

class GlideImageLoader : ImageLoader() {

    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        imageView.scaleType = ImageView.ScaleType.FIT_XY//全屏
        //        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//中心裁剪
        Glide.with(context)
                .load(path)
                .apply(RequestOptions().centerCrop().error(R.mipmap.index_top_bg))
                .into(imageView)
    }

    override fun createImageView(context: Context): ImageView {
        return ImageView(context)
    }
}
