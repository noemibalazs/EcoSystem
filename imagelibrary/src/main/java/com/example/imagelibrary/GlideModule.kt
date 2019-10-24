package com.example.imagelibrary

import android.content.Context
import android.util.Log
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey


@GlideModule
class GlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)

        val memoryCacheSizeBytes = 1024 * 1024 * 20 // 20mb

        val requestOption = RequestOptions()
            .signature(ObjectKey(System.currentTimeMillis() / (24 * 60 * 60 * 1000)))
            .diskCacheStrategy(DiskCacheStrategy.NONE)

        builder.setMemoryCache(LruResourceCache(memoryCacheSizeBytes.toLong()))
        builder.setDefaultRequestOptions(requestOption)
        builder.setLogLevel(Log.ERROR)

    }
}