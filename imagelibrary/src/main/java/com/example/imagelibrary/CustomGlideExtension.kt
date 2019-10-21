package com.example.imagelibrary

import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.request.BaseRequestOptions

@GlideExtension
object CustomGlideExtension {

    @GlideOption
    @JvmStatic
    fun smallCircle(options: BaseRequestOptions<*>): BaseRequestOptions<*> {
        return options.optionalCircleCrop().override(30)
    }

    @GlideOption
    @JvmStatic
    fun defaultImage(options: BaseRequestOptions<*>): BaseRequestOptions<*> {
        return options.override(120, 170)
    }

}