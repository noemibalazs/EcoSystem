package com.example.imagelibrary

import android.content.Context
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder

abstract class CustomPreLoader<Any>(val context: Context) : ListPreloader.PreloadModelProvider<Any> {

    override fun getPreloadRequestBuilder(item: Any): RequestBuilder<*>? {
        return GlideApp.with(context).load(item)
    }
}