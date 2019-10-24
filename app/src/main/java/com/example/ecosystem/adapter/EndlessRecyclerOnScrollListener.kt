package com.example.ecosystem.adapter

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessRecyclerOnScrollListener(val gridLayout: GridLayoutManager) :
    RecyclerView.OnScrollListener() {

    val threshHold = 5 * gridLayout.spanCount
    var loading = true
    var currentPage = 0
    var firstVisibleItem=  0
    var visibleItemCount=  0
    var previousTotal = 0
    var totalItemCount = 0


    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        firstVisibleItem = gridLayout.findFirstVisibleItemPosition()
        totalItemCount = gridLayout.itemCount
        visibleItemCount = recyclerView.childCount

        if (loading && (totalItemCount > previousTotal)){
            loading = false
            previousTotal = totalItemCount
        }

        if (!loading && totalItemCount - visibleItemCount <= firstVisibleItem + threshHold) {
            currentPage++
            onLoadMore(currentPage)
            loading = true
        }
    }

    abstract fun onLoadMore(page: Int)

}