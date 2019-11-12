package com.inbum.imagedialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide

class ImageViewPagerAdapter(private val imgList: ArrayList<String>) : PagerAdapter() {


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val url = imgList[position]
        val layout = LayoutInflater.from(container?.context).inflate(R.layout.item_viewpager, container, false)
        val imageView = layout.findViewById<ImageView>(R.id.image_viewpager)
        Glide.with(container?.context)
            .load(url)
            .into(imageView)

        container?.addView(layout)

        return layout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return imgList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}