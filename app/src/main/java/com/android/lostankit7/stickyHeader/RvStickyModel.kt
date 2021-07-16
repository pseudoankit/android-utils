package com.android.lostankit7.stickyHeader

open class RvStickyModel {
    open val header: String? = null
}

class HeaderModel(hdr: String) : RvStickyModel() {
    override var header = hdr
}

class ContentModel(desc: String,hdr: String) : RvStickyModel() {
    val description = desc
    override val header = hdr
}