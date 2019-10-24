package com.example.imagelibrary

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.request.BaseRequestOptions
import com.bumptech.glide.request.RequestListener

@GlideExtension
object CustomGlideExtensions {

    @GlideOption
    @JvmStatic
    fun smallCircle(options: BaseRequestOptions<*>): BaseRequestOptions<*> {
        return options.optionalCircleCrop().override(30)
    }

    @GlideOption
    @JvmStatic
    fun defaultImage(options: BaseRequestOptions<*>): BaseRequestOptions<*> {
        return options.override(1024, 768)
    }
}