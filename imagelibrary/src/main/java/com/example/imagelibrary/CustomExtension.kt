package com.example.imagelibrary

import androidx.fragment.app.Fragment
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader
import com.bumptech.glide.util.FixedPreloadSizeProvider

fun getSizeProvider(width:Int, height:Int): ListPreloader.PreloadSizeProvider<Any>{
    return FixedPreloadSizeProvider(width,height)
}

fun getRecycleViewPreLoader(fragment: Fragment, modelProvider: ListPreloader.PreloadModelProvider<Any>, sizeProvider:ListPreloader.PreloadSizeProvider<Any>, maxNumber:Int): RecyclerViewPreloader<Any>{
    return RecyclerViewPreloader(fragment, modelProvider, sizeProvider, maxNumber)
}