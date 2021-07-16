package com.android.lostankit7.stickyHeader

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.lostankit7.databinding.HeaderItemRvStickyBinding
import com.android.lostankit7.databinding.ContentItemRvStickyBinding
import com.android.lostankit7.util.asFontAwesome
import com.android.lostankit7.util.showToast

class RvStickyHeaderAdapter(private val mContext: Context, private val mList: MutableList<RvStickyModel>) : RecyclerView.Adapter<RvStickyHeaderAdapter.Companion.BaseViewHolder<*>>() {

    private lateinit var headerBinding : HeaderItemRvStickyBinding
    private lateinit var contentBinding: ContentItemRvStickyBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when(viewType){
            ViewType.Header.ordinal -> {
                headerBinding = HeaderItemRvStickyBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                HeaderViewHolder(headerBinding)
            }
            ViewType.Content.ordinal -> {
                contentBinding = ContentItemRvStickyBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                ContentViewHolder(contentBinding)
            }
            else -> throw IllegalArgumentException("Not a layout")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder){
            is ContentViewHolder -> {
                val item = mList[position] as ContentModel
                holder.binding.tvDescription.text = item.description
                holder.binding.apply {
                    tvEmoji.asFontAwesome()
                    tvStar.asFontAwesome()
                }
            }
            is HeaderViewHolder -> {
                val item = mList[position]as HeaderModel
                holder.binding.tvRvHeader.text = item.header
            }
        }

    }

    override fun getItemCount() = mList.size

    override fun getItemViewType(position: Int): Int {
        return when(mList[position]){
            is HeaderModel -> ViewType.Header.ordinal
            is ContentModel -> ViewType.Content.ordinal
            else -> -1
        }
    }

    inner class HeaderViewHolder(val binding: HeaderItemRvStickyBinding) :BaseViewHolder<HeaderItemRvStickyBinding>(binding.root)
    inner class ContentViewHolder(val binding: ContentItemRvStickyBinding) :BaseViewHolder<ContentItemRvStickyBinding>(binding.root)

    companion object{
        abstract class  BaseViewHolder<T>(view : View) : RecyclerView.ViewHolder(view)
    }

    enum class ViewType{
        Header,
        Content
    }
}

