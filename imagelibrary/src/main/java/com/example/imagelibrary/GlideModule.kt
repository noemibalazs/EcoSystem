package com.example.imagelibrary

import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.annotation.GlideOption
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

    companion object {

        fun displayImage(context: Context, url: String, imageView: ImageView) {

            Glide.with(context)
                .load(url)
                .placeholder(R.drawable.cover)
                .error(R.drawable.cover)
                .into(imageView);
        }

    }
}