package com.android.lostankit7.stickyHeader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.lostankit7.databinding.ActivityStickyHeaderBinding

class StickyHeaderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStickyHeaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStickyHeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = mutableListOf<RvStickyModel>()
        for (i in 1..7){
            list.add(HeaderModel("Header $i"))
            for(j in 1..3){
                list.add(ContentModel("Hii, this is content for Header $i content $j","Header $i"))
            }
        }

        val mLayoutManger = LinearLayoutManager(this)
        val mAdapter = RvStickyHeaderAdapter(this,list)

        binding.rvStickyHeader.apply {
            layoutManager = mLayoutManger
            adapter = mAdapter
            addItemDecoration(DividerItemDecoration(this@StickyHeaderActivity,DividerItemDecoration.VERTICAL))
            addOnScrollListener(RvStickyScroll(list,binding.tvHeader,mLayoutManger))
        }

        binding.tvHeader.text = list[0].header
    }

    internal class RvStickyScroll(val list: MutableList<RvStickyModel>, val tvHeader: TextView,val rvLayoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)

            val position = rvLayoutManager.findFirstCompletelyVisibleItemPosition()
            val item = list[position]

            when (item) {
                is HeaderModel -> tvHeader.visibility = View.GONE
                is ContentModel -> {
                    tvHeader.visibility = View.VISIBLE
                    val header = list[rvLayoutManager.findFirstVisibleItemPosition()].header
                    if(header!=null) tvHeader.text = header
                }
            }
        }
    }

}