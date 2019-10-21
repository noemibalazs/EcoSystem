package com.example.imagelibrary

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

@GlideModule
class CustomGlideModule() : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {

        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.NONE)

        val memoryCacheSizeBytes = (MemorySizeCalculator.Builder(context).build().memoryCacheSize* 1.2).toLong()

        val transitionOptions = DrawableTransitionOptions()
            .crossFade()

        builder
            .setMemoryCache(LruResourceCache(memoryCacheSizeBytes))
            .setDefaultRequestOptions(requestOptions)
            .setDefaultTransitionOptions(Drawable::class.java, transitionOptions)
            .setLogLevel(Log.ERROR)
    }
}